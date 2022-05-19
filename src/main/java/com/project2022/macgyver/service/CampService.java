package com.project2022.macgyver.service;

import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.camp.CampRepository;
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

    /* 캠핑장 상세보기 페이지 */
    @Transactional(readOnly = true)
    public CampResponseDto findById(Long id) {
        Camp entity = campRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 캠핑장이 존재하지 않습니다. id: " + id));

        return new CampResponseDto(entity);
    }

    @Transactional
    public List<CampListResponseDto> findAllById(){
        //추천 캠핑장의 번호를 리스트로 넘겨줘야 함.-> 파라미터 추가해서 controller쪽에서 넘겨줘야할거 같음.
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(6L);
        return campRepository.findAllByIdIn(ids).stream()
                .map(CampListResponseDto::new).collect(Collectors.toList());
    }

}
