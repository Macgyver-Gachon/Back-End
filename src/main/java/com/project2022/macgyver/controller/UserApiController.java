package com.project2022.macgyver.controller;

import com.project2022.macgyver.config.auth.dto.SessionUser;
import com.project2022.macgyver.dto.UserResponseDto;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private final UserService userService;

    @GetMapping("/oauth/token")
    public OauthToken getLogin(@RequestParam("code") String code) {

        OauthToken oauthToken = userService.getAccessToken(code);

        return oauthToken;
    }

}

/*
    //내 정보 보기
    @GetMapping("/user/mypage")
    public UserResponseDto findUserInfo(String userid){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return userService.findByUserid(user.getUserid());
    }

    //회원탈퇴
    @DeleteMapping("/user/mypage")
    public void delete(String userid) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        userService.delete(user.getUserid());
    }

    /*
    @DeleteMapping("/user/mypage/{userid}")
    public String delete(@PathVariable String userid) {
        userService.delete(userid);
        return userid;
    }
    */
    /*

}
