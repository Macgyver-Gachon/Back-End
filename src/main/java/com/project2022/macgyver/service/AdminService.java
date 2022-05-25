package com.project2022.macgyver.service;

import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.UserListResponseDto;
import com.project2022.macgyver.domain.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;

    /*전체 회원 목록 조회*/
    @Transactional
    public List<UserListResponseDto> findAllDesc() {
        return adminRepository.findAllDesc().stream()
                .map(UserListResponseDto::new).collect(Collectors.toList());
    }

    /* 특정 회원 id 검색 */
    @Transactional
    public List<UserListResponseDto> search(String keyword) {
        return adminRepository.findByEmailContaining(keyword).stream()
                .map(UserListResponseDto::new).collect(Collectors.toList());
    }

    /*특정 회원 삭제*/
    @Transactional
    public void delete(Long id) {
        User user = adminRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));
        adminRepository.delete(user);
    }


}
