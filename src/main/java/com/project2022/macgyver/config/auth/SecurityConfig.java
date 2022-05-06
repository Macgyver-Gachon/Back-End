package com.project2022.macgyver.config.auth;

import com.project2022.macgyver.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "css/**", "/images/**", "/js/**", "/all/**").permitAll() //개발에 따라 접근 주소 수정 필요, permitAll 모두 접근 가능
                    //.antMatchers("/api/v1/**", "/useronly/**").hasRole(Role.USER.name()) //user등급 접근 가능 수정필요
                    .antMatchers("/admin/**").hasRole(Role.ADMIN.name()) //admin등급 접근 가능 수정필요
                    .anyRequest().authenticated() //설정된 값 이외의 url들 로그인한 사용자만 가능
                .and()
                    .logout()
                        .logoutSuccessUrl("/")//로그아웃 성공 시 이동 경로
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
}
