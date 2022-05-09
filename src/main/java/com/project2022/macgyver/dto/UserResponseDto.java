package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private String userid;
    private String username;
    private String tel;
    private String sex;
    private String birthyear;
    private String birthday;

    public UserResponseDto(User entity) {
        this.userid = entity.getUserid();
        this.username = entity.getUsername();
        this.tel = entity.getTel();
        this.sex =entity.getSex();
        this.birthyear=entity.getBirthyear();
        this.birthday=entity.getBirthday();
    }
}