package com.project2022.macgyver.domain.bookmark;

import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campingid", referencedColumnName = "id")
    private Camp campingID;

    //없애도 될듯
    @Column(name = "facltnm")
    private String facltNm;

    @Builder
    public Bookmark(User user, Camp campingID, String facltNm){
        this.user=user;
        this.campingID=campingID;
        this.facltNm=facltNm;
    }
}
