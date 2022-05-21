package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.camp.Camp;
import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "캠핑장 조회 응답 DTO")
public class CampResponseDto {
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
    private boolean bookmark;

    public CampResponseDto(Camp camp, boolean bookmark) {
        this.id = camp.getId();
        this.facltNm = camp.getFacltNm();
        this.lineIntro = camp.getLineIntro();
        this.addr1 = camp.getAddr1();
        this.homepage = camp.getHomepage();
        this.resveUrl = camp.getResveUrl();
        this.operPdCl = camp.getOperPdCl();
        this.themaEnvrnCl = camp.getThemaEnvrnCl();
        this.eqpmnLendCl = camp.getEqpmnLendCl();
        this.animalCmgCl = camp.getAnimalCmgCl();
        this.firstImageUrl = camp.getFirstImageUrl();
        this.bookmark = bookmark;
    }
}