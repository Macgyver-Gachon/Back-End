package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.posts.Posts;
import com.project2022.macgyver.domain.user.User;
import lombok.Builder;

public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String imgUrl;
    private User user;

    @Builder
    public PostsSaveRequestDto(String title, String content, String imgUrl, User user) {
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.user = user;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .imgUrl(imgUrl)
                .user(user)
                .build();
    }
}
