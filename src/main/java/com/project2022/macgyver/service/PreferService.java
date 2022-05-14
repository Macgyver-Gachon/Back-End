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
        preferEntity.setUser(user);
        return preferEntity.getId();
    }
}