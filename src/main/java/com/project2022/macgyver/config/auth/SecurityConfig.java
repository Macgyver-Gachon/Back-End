package com.project2022.macgyver.config.auth;

import com.project2022.macgyver.config.jwt.CustomAuthenticationEntryPoint;
import com.project2022.macgyver.config.jwt.JwtRequestFilter;
import com.project2022.macgyver.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserRepository userRepository;
    public static final String FRONT_URL = "http://localhost:3000";

    private final CorsFilter corsFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                    .httpBasic().disable()
                    .formLogin().disable()
                    .addFilter(corsFilter);
        http.authorizeRequests()
                    .antMatchers(FRONT_URL+"/Macgyver/**") //로그인 사용자만 접근 가능 주소
                    .authenticated()
                    .anyRequest().permitAll() //설정된 값 이외의 url 모두 로그인 없이 접근 가능

                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint());

        http.addFilterBefore(new JwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    //따로 빼둠
    //.antMatchers("/api/v1/**", "/useronly/**").hasRole(Role.USER.name()) //user등급 접근 가능 수정필요
    //.antMatchers("/admin/**").hasRole(Role.ADMIN.name()) //admin등급 접근 가능 수정필요
}
