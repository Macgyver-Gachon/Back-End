package com.project2022.macgyver.config.jwt;

public interface JwtProperties {
    String SECRET = "macgyver";
    int EXPIRATION_TIME =  864000000; // 10일
    String TOKEN_PREFIX = "Bearer "; // 공백 필수
    String HEADER_STRING = "Authorization";
}
