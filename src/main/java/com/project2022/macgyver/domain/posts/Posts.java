package com.project2022.macgyver.domain.posts;

import com.project2022.macgyver.domain.BaseTimeEntity;
import com.project2022.macgyver.domain.user.User;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String category;

    @Column
    private String title;

    @Column
    private String content;

    @Column(name="imgurl")
    private String imgUrl;

    @Column
    private String writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User user;

    // 게시글 수정
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}