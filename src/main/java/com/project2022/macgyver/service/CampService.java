package com.project2022.macgyver.service;

import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.camp.CampRepository;
import com.project2022.macgyver.domain.prefer.Prefer;
import com.project2022.macgyver.domain.prefer.PreferRepository;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.CampAllListResponseDto;
import com.project2022.macgyver.dto.CampListResponseDto;
import com.project2022.macgyver.dto.CampResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CampService {
    private final CampRepository campRepository;
    private final PreferRepository preferRepository;

    /* 캠핑장 상세보기 페이지 */
    @Transactional(readOnly = true)
    public CampResponseDto findById(Long id, boolean mark) {
        Camp entity = campRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 캠핑장이 존재하지 않습니다. id: " + id));

        return new CampResponseDto(entity, mark);
    }

    /*캠핑장 추천 리스트 - 이걸 지우진 마시고 새로 만드세요*/
    @Transactional
    public List<CampListResponseDto> findAllById() {
        //추천 캠핑장의 번호를 리스트로 넘겨줘야 함.-> 파라미터 추가해서 controller쪽에서 넘겨줘야할거 같음.
        List<Long> ids = new ArrayList<>();
        ids.add(4L);
        ids.add(6L);
        return campRepository.findAllByIdIn(ids).stream()
                .map(CampListResponseDto::new).collect(Collectors.toList());
    }

    /*캠핑장 전체 리스트*/
    @Transactional
    public List<CampListResponseDto> findAllAsc() {
        return campRepository.findAllAsc().stream()
                .map(CampListResponseDto::new).collect(Collectors.toList());
    }

    /*캠핑장 번호로 찾기*/
    @Transactional(readOnly = true)
    public Camp findBycampId(Long id) {
        return campRepository.findBycampId(id);
    }

    /*캠핑장 번호로 찾기 - 리스트버전*/
    @Transactional(readOnly = true)
    public CampListResponseDto findBycampMark(Long id) {
        return campRepository.findBycampMark(id);
    }

    /*캠핑장 추천 시나리오 1*/
    @Transactional
    public List<CampListResponseDto> recommendNoOne(User user) {
        Prefer prefer = preferRepository.findByUser(user);

        Double clean = 0.0;
        Double kids = 0.0;
        Double entertainment = 0.0;
        Double theme = 0.0;

        //각 요소 평균
        if (prefer.getQ3().equals("1")) clean = 0.04;
        if (prefer.getQ4().equals("1")) kids = 0.19;
        if (prefer.getQ5().equals("1")) entertainment = 0.15;
        if (prefer.getQ6().equals("1")) theme = 0.17;

        if (prefer.getQ1().equals("1") && prefer.getQ2().equals("0")) {
            if (prefer.getQ6().equals("0")) return campRepository.findRecommendNoOne1(clean, kids, entertainment);
            else return campRepository.findRecommendNoOne2(clean, kids, entertainment, theme);
        } else {
            if (prefer.getQ6().equals("0")) return campRepository.findRecommendNoOne3(clean, kids, entertainment);
            else return campRepository.findRecommendNoOne4(clean, kids, entertainment, theme);
        }
    }
}




