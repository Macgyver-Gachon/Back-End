package com.project2022.macgyver.controller;

import com.project2022.macgyver.config.jwt.JwtProperties;
import com.project2022.macgyver.domain.bookmark.Bookmark;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.CampListResponseDto;
import com.project2022.macgyver.service.BookmarkService;
import com.project2022.macgyver.service.CampService;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project2022.macgyver.domain.auth.OauthToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private final UserService userService;
    private final BookmarkService bookmarkService;
    private final CampService campService;

    @GetMapping("/oauth/token")
    public ResponseEntity getLogin(@RequestParam("code") String code) {

        OauthToken oauthToken = userService.getAccessToken(code);

        String jwtToken = userService.SaveUserAndGetToken(oauthToken.getAccess_token());

        System.out.println("컨트롤러에서 토큰 발급================================");
        System.out.println(jwtToken);
        System.out.println("컨트롤러에서 발급 완료================================");

        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);

        return ResponseEntity.ok().headers(headers).body("success");
    }

    //내 정보 보기
    @GetMapping("/user/mypage")
    public User getCurrentUser(HttpServletRequest request){
        System.out.println("Controller 내 정보 보기 시작 ================================");

        User user = userService.getUser(request);

        System.out.println("Controller ================= 반환 user 형태보기 =====================");
        System.out.println(user);

        return user;
    }

    /*나의 북마크 조회*/
    @GetMapping("/user/bookmark")
    public List<CampListResponseDto> myBookmark(HttpServletRequest request){
        User user = userService.getUser(request);

        List<Bookmark> bookmarkList = bookmarkService.findmyBookmark(user.getId());
        List<CampListResponseDto> campList = new ArrayList<>();
        for(Bookmark b : bookmarkList){
            campList.add(campService.findBycampMark(b.getCamp().getId()));
        }
        return campList;
    }

    //회원탈퇴
    @DeleteMapping("/user/delete")
    public void delete(HttpServletRequest request) {
        User user = userService.getUser(request);
        userService.delete(user);
    }

}
