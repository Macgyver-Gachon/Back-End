package com.project2022.macgyver.config.auth.dto;

import com.project2022.macgyver.domain.user.Role;
import com.project2022.macgyver.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String userid;
    private String username;
    private String tel;
    private String sex;
    private String birthyear;
    private String birthday;

    //받아오는 값 수정완료

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String userid, String username, String tel, String sex, String birthyear, String birthday){
        this.attributes=attributes;
        this.nameAttributeKey=nameAttributeKey;
        this.userid=userid;       //email
        this.username=username;   //name
        this.tel=tel;               //mobile
        this.sex=sex;               //gender
        this.birthyear=birthyear;   //birthyear
        this.birthday=birthday;     //birthday
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        //if ("naver".equals(registrationId)) {
            return ofNaver("id", attributes);
        //}
    }

    private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes){
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .userid((String) response.get("email"))
                .username((String) response.get("name"))
                .tel((String) response.get("mobile"))
                .sex((String) response.get("gender"))
                .birthyear((String) response.get("birthyear"))
                .birthday((String) response.get("birthday"))
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity(){
        return User.builder()
                .userid(userid)
                .username(username)
                .tel(tel)
                .sex(sex)
                .birthyear(birthyear)
                .birthday(birthday)
                .role(Role.USER)
                .build();
    }
}
