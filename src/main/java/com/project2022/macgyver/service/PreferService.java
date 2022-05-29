package com.project2022.macgyver.service;

import com.project2022.macgyver.domain.prefer.Prefer;
import com.project2022.macgyver.domain.prefer.PreferRepository;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.PreferSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PreferService {
    private final PreferRepository preferRepository;

    @Transactional
    public Long saveInfo(PreferSaveRequestDto requestDto, User user) {

        Prefer prefer = Prefer.builder()
                .user(user)
                .q1(requestDto.getQ1())
                .q2(requestDto.getQ2())
                .q3(requestDto.getQ3())
                .q4(requestDto.getQ4())
                .q5(requestDto.getQ5())
                .q6(requestDto.getQ6())
                .build();

        preferRepository.save(prefer);

        return prefer.getId();
    }

    /*prefer에 특정 사용자 존재하는지 확인*/
    @Transactional
    public boolean exists(User user){
        return preferRepository.existsByUser(user);
    }

}
