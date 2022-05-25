package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserListResponseDto {
    private Long id;
    private String email;
    private LocalDateTime created_date;

    public UserListResponseDto(User entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.created_date = entity.getCreatedDate();
    }
}
