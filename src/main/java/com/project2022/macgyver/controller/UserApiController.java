package com.project2022.macgyver.controller;

import com.project2022.macgyver.config.jwt.JwtProperties;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project2022.macgyver.domain.auth.OauthToken;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private final UserService userService;

    @GetMapping("/oauth/token")
    public ResponseEntity getLogin(@RequestParam("code") String code) {

        OauthToken oauthToken = userService.getAccessToken(code);

        String jwtToken = userService.SaveUserAndGetToken(oauthToken.getAccess_token());

        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);
        headers.add("Content-Type", "application/json;charset=UTF-8");

        //(4)
        return ResponseEntity.ok().headers(headers).body("success");
    }

    //내 정보 보기
    @GetMapping("/user/mypage")
    public ResponseEntity<Object> getCurrentUser(HttpServletRequest request){
        User user = userService.getUser(request);
        return ResponseEntity.ok().body(user);
    }

}

/*

    //회원탈퇴
    @DeleteMapping("/user/mypage")
    public void delete(HttpServletRequest request) {
        User user = userService.getUser(request);
        userService.delete(user.getId());
    }

    */
