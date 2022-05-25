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
    @Column
    private Long id;
    @Column(name="facltnm")
    private String facltNm; //캠핑장 이름
    @Column(name="lineintro")
    private String lineIntro;
    @Lob
    private String intro;
    @Lob
    @Column(name="featurenm")
    private String featureNm;
    @Column(name="insrncat")
    private String insrncAt;
    private String induty;
    @Column(name="lctcl")
    private String lctCl;
    @Column(name="donm")
    private String doNm;
    @Column(name="sigungunm")
    private String sigunguNm;
    private String addr1;
    private String addr2;
    @Column(name="mapx")
    private float mapX;
    @Column(name="mapy")
    private float mapY;
    private String tel;
    @Lob
    private String homepage;
    private String direction;
    @Lob
    @Column(name="resveurl")
    private String resveUrl;
    @Column(name="resvecl")
    private String resveCl;
    @Column(name="autositeco")
    private int autoSiteCo;
    @Column(name="glampsiteco")
    private int glampSiteCo;
    @Column(name="caravsiteco")
    private int caravSiteCo;
    @Column(name="indvdlcaravsiteco")
    private int indvdlCaravSiteCo;
    @Column(name="sitedstnc")
    private int sitedStnc;
    @Column(name="operpdcl")
    private String operPdCl;
    @Column(name="operdecl")
    private String operDeCl;
    @Column(name="trleracmpnyat")
    private String trlerAcmpnyAt;
    @Column(name="caravacmpnyat")
    private String caravAcmpnyAt;
    @Column(name="toiletco")
    private int toiletCo;
    @Column(name="swrmco")
    private int swrmCo;
    @Column(name="wtrplco")
    private int wtrplCo;
    @Column(name="braziercl")
    private String brazierCl;
    @Column(name="sbrscl")
    private String sbrsCl;
    @Column(name="sbrsetc")
    private String sbrsEtc;
    @Column(name="posblfcltycl")
    private String posblFcltyCl;
    @Column(name="firesensorco")
    private int fireSensorCo;
    @Column(name="themaenvrncl")
    private String themaEnvrnCl;
    @Column(name="eqpmnlendcl")
    private String eqpmnLendCl;
    @Column(name="animalcmgcl")
    private String animalCmgCl;
    @Column(name="toureracl")
    private String tourEraCl;
    @Column(name="firstimageurl")
    private String firstImageUrl;
    @Column(name="glampinnerfclty")
    private String glampInnerFclty;
    @Column(name="caravinnerfclty")
    private String caravInnerFclty;

    @Builder
    public Camp(String facltNm,String lineIntro, String intro, String featureNm, String insrncAt, String induty,
                String lctCl, String doNm, String sigunguNm, String addr1, String addr2, String sbrsCl,
                Float mapX,Float mapY, String tel, String homepage, String direction,
                String resveUrl, String resveCl, Integer autoSiteCo, Integer glampSiteCo,
                Integer caravSiteCo, Integer indvdlCaravSiteCo, Integer sitedStnc,
                String operPdCl, String operDeCl, String trlerAcmpnyAt, String caravInnerFclty, String glampInnerFclty,
                String caravAcmpnyAt, Integer toiletCo, Integer swrmCo, Integer wtrplCo, String brazierCl,
                String sbrsEtc, String posblFcltyCl, Integer fireSensorCo,
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
        this.sbrsCl = sbrsCl;
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
