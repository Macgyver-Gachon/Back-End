package com.project2022.macgyver.service;

import com.project2022.macgyver.domain.posts.Posts;
import com.project2022.macgyver.domain.posts.PostsRepository;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.domain.user.UserRepository;
import com.project2022.macgyver.dto.PostsDto;
import com.project2022.macgyver.dto.PostsListResponseDto;
import com.project2022.macgyver.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j; // logging
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    private final UserRepository userRepository;

    // CREATE
    @Transactional
    public Long save(PostsSaveRequestDto requestDto, User user) {
        Posts post = new Posts();
        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());
        post.setImgUrl(requestDto.getImgUrl());
        post.setUser(user);
        post.setWriter(user.getEmail());
        postsRepository.save(post);
        return post.getId();
    }

    // READ
    @Transactional(readOnly = true) // 게시글 리스트 조회 readOnly 속성으로 조회속도 개선
    public PostsDto.Response findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));

        return new PostsDto.Response(posts);
    }

    // UPDATE
    /* User 객체를 영속화시키고, 영속화된 User 객체를 가져와 데이터를 변경하면
    트랜잭션이 끝날 때 자동으로 DB에 저장해준다. */
    @Transactional
    public void update(Long id, PostsDto.Request dto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        posts.update(dto.getTitle(), dto.getContent());
    }

    // DELETE
    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        postsRepository.delete(posts);
    }

    /*User로 작성글 모두 조회*/
    @Transactional
    public List<PostsListResponseDto> findByUser(Long id){
        return postsRepository.findByUserid(id);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc();
    }
}