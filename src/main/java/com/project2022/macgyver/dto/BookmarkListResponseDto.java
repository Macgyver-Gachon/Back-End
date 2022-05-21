package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.bookmark.Bookmark;
import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.user.User;
import lombok.Getter;

@Getter
public class BookmarkListResponseDto {
    private long id;
    private User user;
    private Camp camp;

    public BookmarkListResponseDto(Bookmark bookmark){
        this.id = bookmark.getId();
        this.user = bookmark.getUser();
        this.camp = bookmark.getCamp();
    }
}
