package com.project2022.macgyver.domain.camp;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Camp {

    @Id
    @GeneratedValue
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
    private String direction;
    private String homepage;
    @Lob
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

    public Camp(Object[] o) {
        this.id = ((BigInteger) o[0]).longValue();
        this.addr1 = (String) o[1];
        this.addr2 = (String) o[2];
        this.autoSiteCo = (int) o[3];
        this.insrncAt = (String) o[4];
        this.brazierCl = (String) o[5];
        this.caravAcmpnyAt = (String) o[6];
        this.caravInnerFclty = (String) o[7];
        this.caravSiteCo = (int) o[8];
        this.direction = (String) o[9];
        this.doNm = (String) o[10];
        this.eqpmnLendCl = (String) o[11];
        this.extshrCo = (int) o[12];
        this.facltNm = (String) o[13];
        this.featureNm = (String) o[14];
        this.fireSensorCo = (int) o[15];
        this.firstImageUrl = (String) o[16];
        this.glampInnerFclty = (String) o[17];
        this.glampSiteCo = (int) o[18];
        this.homepage = (String) o[19];
        this.induty = (String) o[20];
        this.indvdlCaravSiteCo = (int) o[21];
        this.intro = (String) o[22];
        this.lctCl = (String) o[23];
        this.animalCmgCl = (String) o[24];
        this.lineIntro = (String) o[25];
        this.mapX = (float) o[26];
        this.mapY = (float) o[27];
        this.operDeCl = (String) o[28];
        this.operPdCl = (String) o[29];
        this.posblFcltyCl = (String) o[30];
        this.posblFcltyEtc = (String) o[31];
        this.resveCl = (String) o[32];
        this.resveUrl = (String) o[33];
        this.glampInnerFclty = (String) o[34];
        this.sbrsCl = (String) o[35];
        this.sbrsEtc = (String) o[36];
        this.sigunguNm = (String) o[37];
        this.sitedStnc = (int) o[38];
        this.swrmCo = (int) o[39];
        this.tel = (String) o[40];
        this.themaEnvrnCl = (String) o[41];
        this.toiletCo = (int) o[42];
        this.tourEraCl = (String) o[43];
        this.trlerAcmpnyAt = (String) o[44];
        this.wtrplCo = (int) o[45];
        this.gnrlSiteCo = (int) o[46];
    }
}