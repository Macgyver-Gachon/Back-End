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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campingid", referencedColumnName = "id")
    private Camp campingID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facltnm", referencedColumnName = "facltNm")
    private Camp facltNm;

    @Builder
    public Bookmark(User user, Camp campingID, Camp facltNm){
        this.user=user;
        this.campingID=campingID;
        this.facltNm=facltNm;
    }
}
