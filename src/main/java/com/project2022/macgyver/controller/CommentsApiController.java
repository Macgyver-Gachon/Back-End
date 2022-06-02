package com.project2022.macgyver.controller;

import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.CommentsDto;
import com.project2022.macgyver.service.CommentsService;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CommentsApiController {

    private final CommentsService commentsService;
    private final UserService userService;

    /* CREATE */
    @PostMapping("/posts/{id}/comments")
    public Long save(@PathVariable Long id, @RequestBody CommentsDto.Request dto,
                               HttpServletRequest request) {
        User user = userService.getUser(request);
        return commentsService.save(id, user, dto);
    }

    /* READ */
    @GetMapping("/posts/{id}/comments")
    public List<CommentsDto.Response> read(@PathVariable Long id) {
        return commentsService.findAll(id);
    }

    /* UPDATE */
    @PutMapping({"/posts/{id}/comments/{id}"})
    public ResponseEntity update(@PathVariable Long id, @RequestBody CommentsDto.Request dto) {
        commentsService.update(id, dto);
        return ResponseEntity.ok(id);
    }

    /* DELETE */
    @DeleteMapping("/posts/{id}/comments/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        commentsService.delete(id);
        return ResponseEntity.ok(id);
    }
}