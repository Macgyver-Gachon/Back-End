package com.project2022.macgyver.domain.camp;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
public class Camp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_id")
    private Long id;
    private String facltNm; //캠핑장 이름
    private String lineIntro;
    @Lob
    private String intro;
    @Lob
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
    @Lob
    private String homepage;
    private String direction;
    @Lob
    private String resveUrl;
    private String resveCl;
    private int autoSiteCo;
    private int glampSiteCo;
    private int caravSiteCo;
    private int indvdlCaravSiteCo;
    private int sitedStnc;
    private String operPdCl;
    private String operDeCl;
    private String trlerAcmpnyAt;
    private String caravAcmpnyAt;
    private int toiletCo;
    private int swrmCo;
    private int wtrplCo;
    private String brazierCl;
    //private String sbrsCl;
    private String sbrsEtc;
    private String posblFcltyCl;
    private int fireSensorCo;
    private String themaEnvrnCl;
    private String eqpmnLendCl;
    private String animalCmgCl;
    private String tourEraCl;
    private String firstImageUrl;
    private String glampInnerFclty;
    private String caravInnerFclty;

    @Builder
    public Camp(String facltNm,String lineIntro, String intro, String featureNm, String insrncAt, String induty,
                String lctCl, String doNm, String sigunguNm, String addr1, String addr2,
                Float mapX,Float mapY, String tel, String homepage, String direction,
                String resveUrl, String resveCl, Integer autoSiteCo, Integer glampSiteCo,
                Integer caravSiteCo, Integer indvdlCaravSiteCo, Integer sitedStnc,
                String operPdCl, String operDeCl, String trlerAcmpnyAt, String caravInnerFclty, String glampInnerFclty,
                String caravAcmpnyAt, Integer toiletCo, Integer swrmCo, Integer wtrplCo, String brazierCl,
                String sbrsCl, String sbrsEtc, String posblFcltyCl, Integer fireSensorCo,
                String themaEnvrnCl, String eqpmnLendCl, String animalCmgCl, String tourEraCl, String firstImageUrl) {
        this.addr1 = addr1 ;
        this.addr2 = addr2;
        this.direction = direction;
        this.autoSiteCo = autoSiteCo;
        this.insrncAt = insrncAt ;
        this.brazierCl = brazierCl ;
        this.caravAcmpnyAt = caravAcmpnyAt ;
        this.caravSiteCo = caravSiteCo;
        this.doNm = doNm;
        this.eqpmnLendCl = eqpmnLendCl;
        this.facltNm = facltNm;
        this.featureNm = featureNm;
        this.fireSensorCo = fireSensorCo;
        this.glampInnerFclty = glampInnerFclty;
        this.caravInnerFclty = caravInnerFclty;
        this.firstImageUrl = firstImageUrl;
        this.glampSiteCo = glampSiteCo;
        this.homepage = homepage;
        this.induty = induty;
        this.indvdlCaravSiteCo = indvdlCaravSiteCo;
        this.intro = intro;
        this.lctCl = lctCl;
        this.animalCmgCl = animalCmgCl;
        this.lineIntro = lineIntro ;
        this.mapX = mapX;
        this.mapY = mapY;
        this.operDeCl = operDeCl;
        this.operPdCl = operPdCl;
        this.posblFcltyCl = posblFcltyCl;
        this.resveCl = resveCl;
        this.resveUrl = resveUrl;
        //this.sbrsCl = sbrsCl;
        this.sbrsEtc = sbrsEtc;
        this.sigunguNm = sigunguNm;
        this.sitedStnc = sitedStnc;
        this.swrmCo = swrmCo;
        this.tel = tel;
        this.themaEnvrnCl = themaEnvrnCl;
        this.toiletCo = toiletCo;
        this.tourEraCl = tourEraCl;
        this.trlerAcmpnyAt = trlerAcmpnyAt;
        this.wtrplCo = wtrplCo;
    }
}
