package com.project2022.macgyver.controller;

import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.CommentDto;
import com.project2022.macgyver.service.CommentService;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/** REST API Controller */
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CommentApiController {

    private final CommentService commentService;
    private final UserService userService;

    // CREATE
    @PostMapping("/posts/{id}/comments")
    public ResponseEntity save(@PathVariable Long id, @RequestBody CommentDto.Request dto,
                               HttpServletRequest request) {
        User user = userService.getUser(request);
        return ResponseEntity.ok(commentService.save(id, user.getNickname(), dto));
    }

    // READ
    @GetMapping("/posts/{id}/comments")
    public List<CommentDto.Response> read(@PathVariable Long id) {
        return commentService.findAll(id);
    }

    // UPDATE
    @PutMapping({"/posts/{id}/comments/{id}"})
    public ResponseEntity update(@PathVariable Long id, @RequestBody CommentDto.Request dto) {
        commentService.update(id, dto);
        return ResponseEntity.ok(id);
    }

    // DELETE
    @DeleteMapping("/posts/{id}/comments/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.ok(id);
    }
}