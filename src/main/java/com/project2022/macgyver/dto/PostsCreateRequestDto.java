package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.posts.Posts;
import com.project2022.macgyver.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsCreateRequestDto {

    private Long id;
    private User user;
    private String category;
    private String title;
    private String content;
    private LocalDateTime createdDate;

    @Builder
    public PostsCreateRequestDto(Long id, User user, String category, String title, String content, LocalDateTime createdDate) {
        this.id = id;
        this.user = user;
        this.category = category;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }

    public Posts toEntity() {
        return Posts.builder()
                .id(id)
                .user(user)
                .category(category)
                .title(title)
                .content(content)
                .build();
    }
}