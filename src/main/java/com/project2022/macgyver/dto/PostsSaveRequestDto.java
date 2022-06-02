package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.posts.Posts;
import com.project2022.macgyver.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String imgUrl;

    @Builder
    public PostsSaveRequestDto(String title, String content, String imgUrl) {
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .imgUrl(imgUrl)
                .build();
    }
}
