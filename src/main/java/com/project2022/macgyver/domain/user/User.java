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
    private String userid;     //email이 아이디

    @Column
    private String username;   //사용자 이름 name

    @Column
    private String tel;     //휴대폰 전화번호 mobile

    @Column
    private String sex;     //성별 정보 gender

    @Column
    private String birthyear;       //출생연도 birthyear

    @Column
    private String birthday;       //생일 birthday MM-dd

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String userid, String username, String tel, String sex, String birthyear, String birthday, Role role){
        this.userid=userid;
        this.username=username;
        this.tel=tel;
        this.sex=sex;
        this.birthyear=birthyear;
        this.birthday=birthday;
        this.role=role;
    }

    public User update(String username){
        this.username=username;
        this.tel=tel;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}

