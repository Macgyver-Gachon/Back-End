package com.project2022.macgyver.domain.notice;

public class NoticeNotFoundException extends RuntimeException{

    public NoticeNotFoundException(String message) {
        super(message);
    }
}
