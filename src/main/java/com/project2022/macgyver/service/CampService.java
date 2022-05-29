package com.project2022.macgyver.service;

import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.camp.CampRepository;
import com.project2022.macgyver.dto.CampAllListResponseDto;
import com.project2022.macgyver.dto.CampBookmarkListResponseDto;
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
    public CampResponseDto findById(Long id, boolean mark) {
        Camp entity = campRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 캠핑장이 존재하지 않습니다. id: " + id));

        return new CampResponseDto(entity, mark);
    }

    /*캠핑장 추천 리스트*/
    @Transactional
    public List<CampListResponseDto> findAllById(){
        //추천 캠핑장의 번호를 리스트로 넘겨줘야 함.-> 파라미터 추가해서 controller쪽에서 넘겨줘야할거 같음.
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(6L);
        return campRepository.findAllByIdIn(ids).stream()
                .map(CampListResponseDto::new).collect(Collectors.toList());
    }

    /*캠핑장 전체 리스트*/
    @Transactional
    public List<CampAllListResponseDto> findAllAsc() {
        return campRepository.findAllAsc().stream()
                .map(CampAllListResponseDto::new).collect(Collectors.toList());
    }

    /*캠핑장 번호로 찾기*/
    @Transactional(readOnly = true)
    public Camp findBycampId(Long id) {
        return campRepository.findBycampId(id);
    }

    /*캠핑장 번호로 찾기 - 북마크 리스트버전*/
    @Transactional(readOnly = true)
    public CampBookmarkListResponseDto findBycampMark(Long id) {
        return campRepository.findBycampMark(id);
    }

}
