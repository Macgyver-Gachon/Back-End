package com.project2022.macgyver.config.auth.dto;

import com.project2022.macgyver.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//인증된 사용자 정보만 저장

@Getter
public class SessionUser implements Serializable {
    private String userid;      //email
    private String username;    //name
    private String tel;          //mobile
    private String sex;          //gender
    private String birthyear;
    private String birthday;
    //수정함.
    public SessionUser(User user){
        this.userid=user.getUserid();
        this.username=user.getUsername();
        this.tel=user.getTel();
        this.sex=user.getSex();
        this.birthyear=user.getBirthyear();
        this.birthday=user.getBirthday();
    }
}
