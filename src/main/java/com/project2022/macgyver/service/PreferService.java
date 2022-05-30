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
        Prefer prefer = new Prefer();
        if(preferRepository.existsByUser(user)){
            prefer = preferRepository.findByUser(user);
        }
        prefer.setUser(user);
        prefer.setQ1(requestDto.getQ1());
        prefer.setQ2(requestDto.getQ2());
        prefer.setQ3(requestDto.getQ3());
        prefer.setQ4(requestDto.getQ4());
        prefer.setQ5(requestDto.getQ5());
        prefer.setQ6(requestDto.getQ6());

        preferRepository.save(prefer);

        return prefer.getId();
    }

    /*prefer에 특정 사용자 존재하는지 확인*/
    @Transactional
    public boolean exists(User user){
        return preferRepository.existsByUser(user);
    }

}
