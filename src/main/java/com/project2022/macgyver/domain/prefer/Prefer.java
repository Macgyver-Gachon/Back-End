package com.project2022.macgyver.domain.prefer;

import com.project2022.macgyver.domain.BaseTimeEntity;
import com.project2022.macgyver.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Prefer extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "userid", unique = true)
    private User user;

    /* fk=pk로 받지않고 일반컬럼에 추가해보기
    @Id
    private String userid;     //email이 아이디로 들어감.

    @OneToOne//(fetch = FetchType.LAZY)
    @MapsId //@MapsId 는 @id로 지정한 컬럼에 @OneToOne 이나 @ManyToOne 관계를 매핑시키는 역할
    @JoinColumn(referencedColumnName = "userid")
    private User user;
    * */

    /* 질문1: 나는 뚜벅이다
    1 -> 차 없음
    2 -> 차 있음 */
    @Column
    private String q1Walk;

    /* 질문2: 나는 캠핑장비를 갖고 있다.
    1 -> 있음
    2 -> 없음 */
    @Column
    private String q2Equipment;

    /* 질문3: 나는 집 밖이라면 하루쯤 샤워를 건너뛰어도 된다.
    1 -> 됨
    2 -> 안 됨 */
    @Column
    private String q3Shower;

    /* 질문4: 누구와 함께 하는가.
    1 -> 친구/연인
    2 -> 아이동반 가족 */
    @Column
    private String q4Together;

    /* 질문5: 캠핑장 인근에 놀거리가 있다면?
    1 -> 감
    2 -> 그보단 캠핑에 집중함 */
    @Column
    private String q5Sightseeing;

    /* 질문6: 가장 고려하는 대상은?
    1 -> 동물 동반
    2 -> 계절에 맞는 명소
    3 -> 캠핑장 내 이벤트 및 체험 */
    @Column
    private String q6Consider;

    @Builder
    public Prefer(User user ,String q1Walk, String q2Equipment, String q3Shower, String q4Together, String q5Sightseeing, String q6Consider){
        this.user=user;
        this.q1Walk=q1Walk;
        this.q2Equipment=q2Equipment;
        this.q3Shower=q3Shower;
        this.q4Together=q4Together;
        this.q5Sightseeing=q5Sightseeing;
        this.q6Consider=q6Consider;
    }

    public void setUser(User userid) {
        this.user = userid;
    }
}
