package com.project2022.macgyver.controller;

import com.project2022.macgyver.dto.PostsDto;
import com.project2022.macgyver.dto.PostsListResponseDto;
import com.project2022.macgyver.service.PostsService;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** REST API Controller */
@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    private final UserService userService;

    // 글 상세보기
    @GetMapping("/posts/read/{id}")
    public PostsDto.Response posts(@PathVariable Long id) {
        return postsService.findById(id);
    }

    // 글 전체보기
    @GetMapping("/posts")
    public List<PostsListResponseDto> postsList() {
        return postsService.findAllAsc();
    }

    // 글 삭제
    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable Long id) {
        postsService.delete(id);
    }

    // 글 작성
    @PostMapping("/posts")
    public Long save(@RequestBody PostsDto.Request requestDto ) {
        return postsService.save(requestDto);
    }
}