package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.camp.Camp;
import lombok.Getter;

@Getter
public class CampAllListResponseDto {
    private long id;
    private String facltNm;
    private String firstImageUrl;
    private String lineIntro;
    private String addr1;
    private String operPdCl;
    private String themaEnvrnCl;
    private String eqpmnLendCl;
    private String animalCmgCl;
    private String homepage;
    private String resveUrl;
    //북마크 추가

    public CampAllListResponseDto(Camp camp){
        this.id = camp.getId();
        this.facltNm = camp.getFacltNm();
        this.firstImageUrl = camp.getFirstImageUrl();
        this.lineIntro = camp.getLineIntro();
        this.addr1 = camp.getAddr1();
        this.operPdCl = camp.getOperPdCl();
        this.themaEnvrnCl = camp.getThemaEnvrnCl();
        this.eqpmnLendCl = camp.getEqpmnLendCl();
        this.animalCmgCl = camp.getAnimalCmgCl();
        this.homepage = camp.getHomepage();
        this.resveUrl = camp.getResveUrl();
    }
}
