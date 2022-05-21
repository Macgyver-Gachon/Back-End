package com.project2022.macgyver.controller;

import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.CampAllListResponseDto;
import com.project2022.macgyver.dto.CampListResponseDto;
import com.project2022.macgyver.dto.CampResponseDto;
import com.project2022.macgyver.service.CampService;
import com.project2022.macgyver.service.PreferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CampApiController {

    private final CampService campService;
    private final PreferService preferService;
    private final HttpSession session;

    /*캠핑장 추천 페이지*/
    //리다이렉트 수정 필요.. 안되는거같음
    @GetMapping("/camp")
    public String camp(){
        User user = (User)session.getAttribute("user");
        //prefer 정보가 없는 회원
        if (preferService.exists(user.getUserid())) return "redirect:/user/prefer";
        //prefer 정보가 있는 회원
        else return "redirect:/camp/recommend";
    }

    /*캠핑장 추천 페이지*/
    @GetMapping("/camp/recommend")
    public List<CampListResponseDto> campRecommend(){
        User user = (User)session.getAttribute("user");
        //prefer 페이지에서 '다음에 하기' 눌렀을 경우임. 단순 정렬 인기순?리스트로 반환 & 서비스에 ids 리스트를 파라미터로 넘겨주게 수정해야함.
        //if (preferService.exists(user.getUserid())) return campService.findAllById();
        //prefer 존재하는 경우. 리스트로 반환 & 서비스에 ids 리스트를 파라미터로 넘겨주게 수정해야함.
        //else
        return campService.findAllById();
    }

    /* 캠핑장 상세보기 페이지 - 보류 */
    @GetMapping("/camp/{id}")
    public CampResponseDto campInfo(@PathVariable Long id) {
        return campService.findById(id);
    }

    /*캠핑장 전체 리스트 보내기 - 상세보기 페이지*/
    @GetMapping("/camp/list")
    public List<CampAllListResponseDto> campList() {
        return campService.findAllAsc();
    }

}
