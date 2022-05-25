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
        Prefer prefer = requestDto.toEntity();
        prefer.setUser(user);
        Prefer preferEntity = preferRepository.save(prefer);
        preferEntity.setUser(user);     //이부분 .getUserid로 안바꿔도 되는건지?
        return preferEntity.getId();
    }

    /*prefer에 특정 사용자 존재하는지 확인*/
    @Transactional
    public boolean exists(User user){
        return preferRepository.existsByUser(user);
    }

}
