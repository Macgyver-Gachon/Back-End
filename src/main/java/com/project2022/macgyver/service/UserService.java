package com.project2022.macgyver.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project2022.macgyver.config.jwt.JwtProperties;
import com.project2022.macgyver.domain.auth.KakaoProfile;
import com.project2022.macgyver.domain.user.Role;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.project2022.macgyver.domain.auth.OauthToken;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static com.project2022.macgyver.config.auth.SecurityConfig.FRONT_URL;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    /*
    //환경 변수 가져오기
    @Value("${kakao.clientId}")
    String client_id;

    @Value("${kakao.secret}")
    String client_secret;
     */

    public OauthToken getAccessToken(String code) {

        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", "a31288d41e5fc2bfcf3d40ec4cf3b196");
        params.add("redirect_uri", FRONT_URL + "/Macgyver/login");
        params.add("code", code);
        params.add("client_secret", "GZMFXVPzW1t5LESAkJUmoazVe3bNhBB4");

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        ResponseEntity<String> accessTokenResponse = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        OauthToken oauthToken = null;
        try {
            oauthToken = objectMapper.readValue(accessTokenResponse.getBody(), OauthToken.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return oauthToken;
    }

    public String SaveUserAndGetToken(String token) {

        KakaoProfile profile = findProfile(token);

        User user = userRepository.findByEmail(profile.getKakao_account().getEmail());

        if (user == null) {
            user = User.builder()
                    .kakaoid(profile.getId())
                    .nickname(profile.getKakao_account().getProfile().getNickname())
                    .email(profile.getKakao_account().getEmail())
                    .gender(profile.getKakao_account().getGender())
                    .birthday(profile.getKakao_account().getBirthday())
                    .role(Role.USER)
                    .build();

            userRepository.save(user);
        }

        return createToken(user);
    }

    public String createToken(User user) {

        String jwtToken = JWT.create()

                .withSubject(user.getEmail())
                .withExpiresAt(new Date(System.currentTimeMillis()+ JwtProperties.EXPIRATION_TIME))

                .withClaim("id", user.getKakaoid())
                .withClaim("nickname", user.getNickname())

                .sign(Algorithm.HMAC512(JwtProperties.SECRET));

        return jwtToken;
    }

    public KakaoProfile findProfile(String token) {

        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token); //(1-4)
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest =
                new HttpEntity<>(headers);

        // Http 요청 (POST 방식) 후, response 변수에 응답을 받음
        ResponseEntity<String> kakaoProfileResponse = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = objectMapper.readValue(kakaoProfileResponse.getBody(), KakaoProfile.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return kakaoProfile;
    }

    public User getUser(HttpServletRequest request) {
        Long id = (Long) request.getAttribute("id");
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return user;
    }
}


    /*
    @Transactional(readOnly = true)
    public UserResponseDto findByUserid(String userid) {
        User entity = userRepository.findByUserid(userid)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + userid));

        return new UserResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public User findByid(String userid) {
        return userRepository.findById(userid);
    }

    @Transactional
    public void delete(String userid) {
        User user = userRepository.findByUserid(userid)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + userid));

        userRepository.delete(user);
    }

}
     */


