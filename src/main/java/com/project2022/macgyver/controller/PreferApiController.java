package com.project2022.macgyver.controller;

import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.PreferSaveRequestDto;
import com.project2022.macgyver.service.PreferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class PreferApiController {
    private final PreferService preferService;
    private final HttpSession session;

    @PostMapping("/user/prefer")
    public Long save(@RequestBody PreferSaveRequestDto requestDto) {
        User user = (User)session.getAttribute("user");
        return preferService.saveInfo(requestDto, user);
    }
}
