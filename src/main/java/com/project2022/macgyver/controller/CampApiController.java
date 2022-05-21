package com.project2022.macgyver.controller;

import com.project2022.macgyver.config.auth.dto.SessionUser;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CampApiController {

    private final CampService campService;
    private final PreferService preferService;
    private final UserService userService;
    private final BookmarkService bookmarkService;
    private final HttpSession session;

    /*캠핑장 추천 페이지 - 최초접근*/
    @GetMapping("/camp")
    public String camp(){
        SessionUser sessionUser = (SessionUser)session.getAttribute("user");
        User user = userService.findByid(sessionUser.getUserid());
        //prefer 정보가 있는 회원
        if (preferService.exists(user)) return "redirect:/camp/recommend";
        //prefer 정보가 없는 회원
        else return "redirect:/user/prefer";
    }

    /*캠핑장 추천 페이지*/
    @GetMapping("/camp/recommend")
    public List<CampListResponseDto> campRecommend(){
        //수정필요
        SessionUser sessionUser = (SessionUser)session.getAttribute("user");
        User user = userService.findByid(sessionUser.getUserid());
        //prefer 페이지에서 '다음에 하기' 눌렀을 경우임. 단순 정렬 인기순?리스트로 반환 & 서비스에 ids 리스트를 파라미터로 넘겨주게 수정해야함.
        //if (preferService.exists(sessionUser.getUserid())) return campService.findAllById();
        //prefer 존재하는 경우. 리스트로 반환 & 서비스에 ids 리스트를 파라미터로 넘겨주게 수정해야함.
        //else
        return campService.findAllById();
    }

    /* 캠핑장 상세보기 페이지 - 단건 */
    @GetMapping("/camp/{id}")
    public CampResponseDto campInfo(@PathVariable Long id) {
        boolean mark = false;

        SessionUser sessionUser = (SessionUser)session.getAttribute("user");
        User user = userService.findByid(sessionUser.getUserid());
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

        return campService.findAllAsc();
    }
}
