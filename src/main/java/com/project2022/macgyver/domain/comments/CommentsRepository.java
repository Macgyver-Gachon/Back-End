package com.project2022.macgyver.domain.comments;

import com.project2022.macgyver.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    /* 게시글 댓글 목록 가져오기 */
    List<Comments> getCommentByPostsOrderById(Posts posts);
}