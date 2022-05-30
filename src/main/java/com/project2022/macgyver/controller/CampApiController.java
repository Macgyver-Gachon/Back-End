package com.project2022.macgyver.controller;

import com.project2022.macgyver.domain.bookmark.Bookmark;
import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.CampAllListResponseDto;
import com.project2022.macgyver.dto.CampListResponseDto;
import com.project2022.macgyver.dto.CampResponseDto;
import com.project2022.macgyver.service.BookmarkService;
import com.project2022.macgyver.service.CampService;
import com.project2022.macgyver.service.PreferService;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CampApiController {

    private final CampService campService;
    private final PreferService preferService;
    private final UserService userService;
    private final BookmarkService bookmarkService;

    //캠핑장 추천 페이지 - 최초접근
    @GetMapping("/camp")
    public String camp(HttpServletRequest request){
        User user = userService.getUser(request);

        //prefer 정보가 있는 회원
        if (preferService.exists(user)) return "redirect:/camp/recommend";
        //prefer 정보가 없는 회원
        else return "redirect:/user/prefer";
    }

    //캠핑장 추천 페이지
    @GetMapping("/camp/recommend")
    public List<CampListResponseDto> campRecommend(HttpServletRequest request){
        User user = userService.getUser(request);

        //북마크 있는 경우 - 시나리오2 - return 서비스는 임의로 설정해둔 것. 알아서 수정
        if (bookmarkService.exists(user)) return campService.findAllById();
        //북마크 없는 경우 - 시나리오1
        else return campService.recommendNoOne(user);
    }

    // 캠핑장 상세보기 페이지 - 단건
    @GetMapping("/camp/{id}")
    public CampResponseDto campInfo(@PathVariable Long id, HttpServletRequest request) {
        boolean mark = false;

        User user = userService.getUser(request);
        Camp camp = campService.findBycampId(id);

        Bookmark bookmark = bookmarkService.findByUserAndCamp(user, camp);
        if(bookmark != null){
            //북마크 되어있는 상태
            mark = true;
        }

        return campService.findById(id, mark);
    }

    /*캠핑장 전체 리스트 보내기 - 상세보기 페이지*/
    @GetMapping("/camp/list")
    public List<CampAllListResponseDto> campList() {
        System.out.println("캠핑장 전체 리스트 출력");
        return campService.findAllAsc();
    }

    @GetMapping("/test")
    public String test() throws URISyntaxException {
        URI forwardUri = new URI("https://www.daum.net");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate.getForObject(forwardUri, String.class);
    }
}
