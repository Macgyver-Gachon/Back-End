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
import javax.servlet.http.HttpServletResponse;

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

        System.out.println("컨트롤러에서 토큰 발급================================");
        System.out.println(jwtToken);
        System.out.println("컨트롤러에서 발급 완료================================");

        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);

        return ResponseEntity.ok().headers(headers).body("success");
    }

    //내 정보 보기
    @GetMapping("/user/mypage")
    public ResponseEntity<Object> getCurrentUser(HttpServletRequest request){
        System.out.println("Controller 내 정보 보기 시작 ================================");

        User user = userService.getUser(request);

        System.out.println("Controller ================= 반환 user 형태보기 =====================");
        System.out.println(user);

        return ResponseEntity.ok().body(user);
    }

    //회원탈퇴
    @DeleteMapping("/user/delete")
    public void delete(HttpServletRequest request) {
        User user = userService.getUser(request);
        userService.delete(user);
    }

}
