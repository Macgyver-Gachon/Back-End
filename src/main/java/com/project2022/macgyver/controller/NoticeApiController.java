package com.project2022.macgyver.controller;

import com.project2022.macgyver.domain.notice.Notice;
import com.project2022.macgyver.domain.notice.NoticeInput;
import com.project2022.macgyver.domain.notice.NoticeNotFoundException;
import com.project2022.macgyver.domain.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class NoticeApiController {

    private final NoticeRepository noticeRepository;

    @GetMapping("/notice")
    public List<NoticeInput> notice() {
        List<NoticeInput> noticeList = new ArrayList<>();
        return noticeList;
    }

    @PostMapping("/notice")
    public ResponseEntity<Object> addNotice(@RequestBody NoticeInput noticeInput) {

        if(noticeInput.getTitle() == null || noticeInput.getTitle().length() < 1 ||
        noticeInput.getContents() == null || noticeInput.getContents().length() < 1) {
            return new ResponseEntity<>("입력값이 정확하지 않습니다.", HttpStatus.BAD_REQUEST);
        }
        noticeRepository.save(Notice.builder()
                .title(noticeInput.getTitle())
                .contents(noticeInput.getContents())
                .created_Date(LocalDateTime.now())
                .build()
        );

        return ResponseEntity.ok().build();
    }

    @GetMapping("/notice/{id}")
    public Notice getNotice(@PathVariable long id) {
        return noticeRepository.findById(id).orElseThrow(null);
    }

    @PutMapping("/notice/{id}")
    public void updateNotice(@PathVariable long id, @RequestBody NoticeInput noticeInput) {
      Notice notice = noticeRepository.findById(id).orElseThrow(() -> new
              NoticeNotFoundException("공지사항의 글이 존재하지 않습니다."));
      notice.setTitle(noticeInput.getTitle());
      notice.setContents(noticeInput.getContents());
      notice.setCreated_Date(LocalDateTime.now());
      noticeRepository.save(notice);
    }

    @DeleteMapping("/notice/{id}")
    public void deleteNotice(@PathVariable Long id) {
        Notice notice = noticeRepository.findById(id).orElseThrow(() -> new
                NoticeNotFoundException("공지사항의 글이 존재하지 않습니다."));
        noticeRepository.delete(notice);
    }
}
