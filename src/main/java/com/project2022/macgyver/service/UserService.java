package com.project2022.macgyver.service;

import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.domain.user.UserRepository;
import com.project2022.macgyver.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponseDto findByUserid(String userid) {
        User entity = userRepository.findByUserid(userid)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + userid));

        return new UserResponseDto(entity);
    }

    @Transactional
    public void delete(String userid) {
        User user = userRepository.findByUserid(userid)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + userid));

        userRepository.delete(user);
    }

}


