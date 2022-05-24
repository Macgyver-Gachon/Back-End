package com.project2022.macgyver.config.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project2022.macgyver.domain.auth.Token;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.domain.user.UserRepository;
import com.project2022.macgyver.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        // todo 이 부분 수정 필요
        // todo 이 부분 받아오는 것으로 로직 수정
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        System.out.println(oAuth2User);
        Map<String, Object> map = oAuth2User.getAttributes();
        //Map map2 = (Map) map.get("email");
        String email = (String) map.get("email");
        log.info("Attributes에서 꺼낸 = {}", email);
        User user = userRepository.findById(email);

        log.info("Principal에서 꺼낸 OAuth2User = {}", oAuth2User);
        // 최초 로그인이라면 회원가입 처리를 한다.
        String targetUrl;
        log.info("토큰 발행 시작");

        Token token = tokenService.generateToken(user.getUserid(), "USER");
        log.info("{}", token);
        targetUrl = UriComponentsBuilder.fromUriString("/myPage")
                                        .queryParam("token", token)
                                        .build().toUriString();
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}