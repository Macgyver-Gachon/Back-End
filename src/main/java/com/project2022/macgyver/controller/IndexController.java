package com.project2022.macgyver.controller;

import javax.servlet.http.HttpSession;
import com.project2022.macgyver.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user!=null){
            model.addAttribute("userName", user.getUsername());
        }
        return "index";
    }

    //테스트
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    //테스트
    @GetMapping("/all")
    public String all() {
        return "all";
    }

    //테스트
    @GetMapping("/useronly")
    public String useronly() {
        return "useronly";
    }
}
