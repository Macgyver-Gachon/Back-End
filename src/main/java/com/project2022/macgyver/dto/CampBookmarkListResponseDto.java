package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.camp.Camp;

public class CampBookmarkListResponseDto {
    private long id;
    private String facltNm;
    private String featureNm;
    private String addr1;
    private String addr2;
    private String lineIntro;
    private String firstImageUrl;
    private boolean mark;

    public CampBookmarkListResponseDto(Camp camp) {
        this.id = camp.getId();
        this.facltNm = camp.getFacltNm();
        this.featureNm = camp.getFeatureNm();
        this.addr1 = camp.getAddr1();
        this.addr2 = camp.getAddr2();
        this.lineIntro = camp.getLineIntro();
        this.firstImageUrl = camp.getFirstImageUrl();
        this.mark = true;
    }
}
