package com.project2022.macgyver.controller;

import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.PreferSaveRequestDto;
import com.project2022.macgyver.service.PreferService;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


//@RequestMapping("/api") 추가필요
@RequiredArgsConstructor
@RestController
public class PreferApiController {
    private final PreferService preferService;
    private final UserService userService;

    /*
    @PostMapping("/user/prefer")
    public Long save(@RequestBody PreferSaveRequestDto requestDto, HttpServletRequest request) {
        User user = userService.getUser(request);
        //다음에 하기 누르면 "camp/recommend"로 바로 리다이렉트 되도록 프론트에서?
        return preferService.saveInfo(requestDto, user);
    }
     */
}
