package com.project2022.macgyver.domain.comment;


import com.project2022.macgyver.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 게시글 댓글 목록 가져오기
    List<Comment> getCommentByPostsOrderById(Posts posts);
}