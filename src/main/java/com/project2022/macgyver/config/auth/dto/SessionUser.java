package com.project2022.macgyver.config.auth.dto;

import com.project2022.macgyver.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//인증된 사용자 정보만 저장

@Getter
public class SessionUser implements Serializable {
    public String name;
    public String email;
    public String picture;
    //수정필
    public SessionUser(User user){
        this.name=user.getName();
        this.email=user.getEmail();
        this.picture=user.getPicture();
    }
}
