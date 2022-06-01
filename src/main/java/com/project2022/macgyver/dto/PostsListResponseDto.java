package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String category;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdDate;

    private  String imgUrl;
    private Long userid;

    public PostsListResponseDto(Posts posts) {
        this.id = posts.getId();
        this.category = posts.getCategory();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.createdDate = posts.getCreatedDate();
        this.writer = posts.getWriter();
        this.imgUrl = posts.getImgUrl();
        this.userid = posts.getUser().getId();
    }
}