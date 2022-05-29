package com.project2022.macgyver.controller;

import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.PostsDto;
import com.project2022.macgyver.service.PostsService;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/** REST API Controller */
@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    private final UserService userService;


    // CREATE
    @PostMapping("/posts")
    public ResponseEntity save(@RequestBody PostsDto.Request dto, HttpServletRequest request) {
        User user = userService.getUser(request);
        return ResponseEntity.ok(postsService.save(dto, user.getNickname()));
    }

    // READ
    @GetMapping("/posts/{id}")
    public ResponseEntity read(@PathVariable Long id) {
        return ResponseEntity.ok(postsService.findById(id));
    }

    // UPDATE
    @PutMapping("/posts/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody PostsDto.Request dto) {
        postsService.update(id, dto);
        return ResponseEntity.ok(id);
    }

    // DELETE
    @DeleteMapping("/posts/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        postsService.delete(id);
        return ResponseEntity.ok(id);
    }
}