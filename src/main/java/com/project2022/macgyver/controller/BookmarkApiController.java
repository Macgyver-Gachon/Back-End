package com.project2022.macgyver.controller;

import com.project2022.macgyver.config.auth.dto.SessionUser;
import com.project2022.macgyver.domain.bookmark.Bookmark;
import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.service.CampService;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class BookmarkApiController {

    private final UserService userService;
    private final CampService campService;
    private final HttpSession httpSession;

    @PostMapping(value="/wishItem/{id}")
    public String addBookmark(@PathVariable(value="id") Long id){
        String result = "fail";
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        User user = userService.findByid(sessionUser.getUserid());
        Camp camp = campService.findBycampId(id);
        /*
        Bookmark bookmark = bookmarkService.findByUserAndCamp(user, camp);
        if(bookmark != null){
            result = "duplicate";
        } else {
            bookmarkService.save(user, camp);
            result = "success";
        }

         */
        return result;
    }

}
