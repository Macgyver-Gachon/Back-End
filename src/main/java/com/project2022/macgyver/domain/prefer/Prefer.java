package com.project2022.macgyver.domain.prefer;

import com.project2022.macgyver.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
//@NoArgsConstructor
@Entity
public class Prefer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User user;

    /* 질문1: 나는 뚜벅이다
    0 -> no
    1 -> yes */
    @Column
    private String q1;

    /* 질문2: 나는 캠핑장비를 갖고 있다.
    0 -> no
    1 -> yes */
    @Column
    private String q2;

    /* 질문3: 나는 집 밖이라면 하루쯤 샤워를 건너뛰어도 된다.
    0 -> no
    1 -> yes */
    @Column
    private String q3;

    /* 질문4: 누구와 함께 하는가.
    0 -> 친구/연인
    1 -> 아이동반 가족 */
    @Column
    private String q4;

    /* 질문5: 캠핑장 인근에 놀거리가 있다면?
    0 -> no
    1 -> yes */
    @Column
    private String q5;

    /* 질문6: 가장 고려하는 대상은?
    0 -> 동물 동반
    1 -> 계절에 맞는 명소
    2 -> 캠핑장 내 이벤트 및 체험 */
    @Column
    private String q6;

    public Prefer(){

    }

    @Builder
    public Prefer(User user, String q1, String q2, String q3, String q4, String q5, String q6){
        this.user=user;
        this.q1=q1;
        this.q2=q2;
        this.q3=q3;
        this.q4=q4;
        this.q5=q5;
        this.q6=q6;
    }

    //public void setUser(User id) {this.user = id;}
}
