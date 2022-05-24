package com.project2022.macgyver.config.auth;

import com.project2022.macgyver.domain.user.Role;
import com.project2022.macgyver.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final TokenService tokenService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .cors().configurationSource(corsConfigurationSource())
                //.headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "css/**", "/images/**", "/js/**", "/camp/list").permitAll() //개발에 따라 접근 주소 수정 필요, permitAll 모두 접근 가능
                    //.antMatchers("/api/v1/**", "/user/**").hasRole(Role.USER.name()) //user등급 접근 가능 수정필요
                    //.antMatchers("/admin/**").hasRole(Role.ADMIN.name()) //admin등급 접근 가능 수정필요
                    .anyRequest().authenticated() //설정된 값 이외의 url들 로그인한 사용자만 가능
                .and()
                    .logout()
                        .logoutSuccessUrl("/")//로그아웃 성공 시 이동 경로
                .and()
                    .addFilterBefore(new JwtAuthFilter(tokenService), UsernamePasswordAuthenticationFilter.class) //추가
                    .oauth2Login()
                    .successHandler(oAuth2SuccessHandler) //추가
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService);

    }

    //cors 추가
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("http://localhost:3000");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
