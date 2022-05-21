package com.project2022.macgyver.domain.bookmark;

import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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
    private Camp camp;

    @Builder
    public Bookmark(User user, Camp camp){
        this.user=user;
        this.camp=camp;
    }
}
