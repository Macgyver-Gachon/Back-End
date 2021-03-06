package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.posts.Posts;
import com.project2022.macgyver.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;

/**
 * request, response DTO 클래스를 하나로 묶어 InnerStaticClass로 한 번에 관리
 */
public class PostsDto {

    /** 게시글의 등록과 수정을 처리할 요청(Request) 클래스 */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private Long id;
        private String category;
        private String title;
        private String writer;
        private String content;
        private LocalDateTime createdDate, modifiedDate;
        private String imgUrl;
        private User user;

        /* Dto -> Entity */
        public Posts toEntity() {
            Posts posts = Posts.builder()
                    .id(id)
                    .category(category)
                    .title(title)
                    .writer(writer)
                    .content(content)
                    .user(user)
                    .imgUrl((imgUrl))
                    .build();

            return posts;
        }
    }

    /**
     * 게시글 정보를 리턴할 응답(Response) 클래스
     * Entity 클래스를 생성자 파라미터로 받아 데이터를 Dto로 변환하여 응답
     * 별도의 전달 객체를 활용해 연관관계를 맺은 엔티티간의 무한참조를 방지
     */
    @Getter
    public static class Response {
        private Long id;
        private String category;
        private String title;
        private String writer;
        private String content;
        private LocalDateTime createdDate, modifiedDate;

        private String imgUrl;
        private Long userid;

        /* Entity -> Dto*/
        public Response(Posts posts) {
            this.id = posts.getId();
            this.category = posts.getCategory();
            this.title = posts.getTitle();
            this.writer = posts.getWriter();
            this.content = posts.getContent();
            this.createdDate = posts.getCreatedDate();
            this.modifiedDate = posts.getModifiedDate();
            this.imgUrl = posts.getImgUrl();
            this.userid = posts.getUser().getId();
            }
    }
}