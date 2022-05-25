package com.project2022.macgyver.controller;

import com.project2022.macgyver.config.jwt.JwtProperties;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project2022.macgyver.domain.auth.OauthToken;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    private  UserService userService;

    @GetMapping("/oauth/token")
    public ResponseEntity getLogin(@RequestParam("code") String code) {

        OauthToken oauthToken = userService.getAccessToken(code);

        String jwtToken = userService.SaveUserAndGetToken(oauthToken.getAccess_token());
        System.out.printf("jwtToken은 컨트롤러 %s이다.",jwtToken);

        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);

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
