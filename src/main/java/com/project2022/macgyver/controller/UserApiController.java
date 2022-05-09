package com.project2022.macgyver.controller;

import com.project2022.macgyver.config.auth.dto.SessionUser;
import com.project2022.macgyver.dto.UserResponseDto;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final HttpSession httpSession;

    //내 정보 보기
    @GetMapping("/user/mypage")
    public UserResponseDto findUserInfo(String userid){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return userService.findByUserid(user.getUserid());
    }

    //회원탈퇴
    @DeleteMapping("/user/mypage")
    public String delete(String userid) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        userService.delete(userid);
        return userid;
    }

    /*
    @DeleteMapping("/user/mypage/{userid}")
    public String delete(@PathVariable String userid) {
        userService.delete(userid);
        return userid;
    }
    */

}
