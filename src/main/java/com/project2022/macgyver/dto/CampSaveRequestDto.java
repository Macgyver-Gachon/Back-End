package com.project2022.macgyver.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class CampSaveRequestDto {

    private String facltNm;
    private String lineIntro;
    private String intro;
    private String featureNm;
    private String insrncAt;
    private String induty;
    private String lctCl;
    private String doNm;
    private String sigunguNm;
    private String addr1;
    private String addr2;
    private float mapX;
    private float mapY;
    private String tel;
    private String direction;
    private String homepage;
    private String resveUrl;
    private String resveCl;
    private int gnrlSiteCo;
    private int autoSiteCo;
    private int glampSiteCo;
    private int caravSiteCo;
    private int indvdlCaravSiteCo;
    private int sitedStnc;
    private String glampInnerFclty;
    private String caravInnerFclty;
    private String operPdCl;
    private String operDeCl;
    private String trlerAcmpnyAt;
    private String caravAcmpnyAt;
    private int toiletCo;
    private int swrmCo;
    private int wtrplCo;
    private String brazierCl;
    private String sbrsCl;
    private String sbrsEtc;
    private String posblFcltyCl;
    private String posblFcltyEtc;
    private int fireSensorCo;
    private int extshrCo;
    private String themaEnvrnCl;
    private String eqpmnLendCl;
    private String animalCmgCl;
    private String tourEraCl;
    private String firstImageUrl;

}