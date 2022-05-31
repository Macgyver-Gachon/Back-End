package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.camp.Camp;
import lombok.Getter;

@Getter
public class CampListResponseDto {
    private long id;
    private String facltNm;
    private String featureNm;
    private String addr1;
    private String lineIntro;
    private String firstImageUrl;

    public CampListResponseDto(Camp camp) {
        this.id = camp.getId();
        this.facltNm = camp.getFacltNm();
        this.featureNm = camp.getFeatureNm();
        this.addr1 = camp.getAddr1();
        this.lineIntro = camp.getLineIntro();
        this.firstImageUrl = camp.getFirstImageUrl();
    }
}
