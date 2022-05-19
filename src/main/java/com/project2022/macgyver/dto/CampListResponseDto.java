package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.camp.Camp;
import lombok.Getter;

@Getter
public class CampListResponseDto {
    private String facltNm;
    private String addr1;
    private String addr2;
    private String firstImageUrl;

    public CampListResponseDto(Camp camp) {
        this.facltNm = camp.getFacltNm();
        this.addr1 = camp.getAddr1();
        this.addr2 = camp.getAddr2();
        this.firstImageUrl = camp.getFirstImageUrl();
    }
}
