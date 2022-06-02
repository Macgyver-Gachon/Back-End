package com.project2022.macgyver.service;

import com.project2022.macgyver.domain.comments.Comments;
import com.project2022.macgyver.domain.comments.CommentsRepository;
import com.project2022.macgyver.domain.posts.Posts;
import com.project2022.macgyver.domain.posts.PostsRepository;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.domain.user.UserRepository;
import com.project2022.macgyver.dto.CommentsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final UserRepository userRepository;
    private final PostsRepository postsRepository;

    /* CREATE */
    @Transactional
    public Long save(Long id, User user, CommentsDto.Request requestDto) {
        user = userRepository.findByEmail(user.getEmail());
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다. " + id));

        requestDto.setUser(user);
        requestDto.setPosts(posts);
        Comments comments = requestDto.toEntity();
        commentsRepository.save(comments);
        return comments.getId();
    }

    /* READ */
    @Transactional(readOnly = true)
    public List<CommentsDto.Response> findAll(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));
        List<Comments> comments = posts.getComments();
        return comments.stream().map(CommentsDto.Response::new).collect(Collectors.toList());
    }

    /* UPDATE */
    @Transactional
    public void update(Long id, CommentsDto.Request dto) {
        Comments comment = commentsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + id));

        comment.update(dto.getComment());
    }

    /* DELETE */
    @Transactional
    public void delete(Long id) {
        Comments comments = commentsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id=" + id));

        commentsRepository.delete(comments);
    }
}