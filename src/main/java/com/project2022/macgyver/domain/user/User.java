package com.project2022.macgyver.domain.user;

import com.project2022.macgyver.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increase
    private Long id;

    @Column
    private Long kakaoid;

    @Column
    private String nickname ;

    @Column
    private String email;

    @Column
    private String gender;

    @Column
    private String birthday;       //생일 birthday MM-dd

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(Long kakaoid, String nickname, String email, String gender, String birthday, Role role){
        this.kakaoid = kakaoid;
        this.nickname = nickname;
        this.email = email;
        this.gender=gender;
        this.birthday=birthday;
        this.role=role;
    }

}

