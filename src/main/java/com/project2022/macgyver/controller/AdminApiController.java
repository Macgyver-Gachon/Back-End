package com.project2022.macgyver.controller;

import com.project2022.macgyver.dto.UserListResponseDto;
import com.project2022.macgyver.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AdminApiController {

    private final AdminService adminService;

    /*전체 회원 목록 조회*/
    @GetMapping("/admin/userList")
    public List<UserListResponseDto> findAllDesc() {
        return adminService.findAllDesc();
    }

    /*특정 회원 id 검색*/
    //이런 식으로 전달되면 admin/userList/search?keyword=hayoon 값 반환
    @GetMapping("admin/userList/search")
    public List<UserListResponseDto> search(String keyword, Model model) {
        return adminService.search(keyword);
    }

    /*특정 회원 삭제*/
    @DeleteMapping("/admin/userList/{userid}")
    public String delete(@PathVariable String userid) {
        adminService.delete(userid);
        return userid;
    }
}
