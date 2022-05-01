package com.project2022.macgyver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user/signUp")
    public String userSave(){
        return "/user/welcome";
    }
}
