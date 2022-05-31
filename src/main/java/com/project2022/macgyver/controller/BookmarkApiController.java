package com.project2022.macgyver.controller;

import com.project2022.macgyver.domain.bookmark.Bookmark;
import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.service.BookmarkService;
import com.project2022.macgyver.service.CampService;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class BookmarkApiController {

    private final UserService userService;
    private final CampService campService;
    private final BookmarkService bookmarkService;

    /*북마크 등록*/
    @PostMapping("/bookmark/{id}")
    public String addBookmark(@PathVariable(value="id") Long id, HttpServletRequest request){
        String result;
        User user = userService.getUser(request);
        Camp camp = campService.findBycampId(id);

        Bookmark bookmark = bookmarkService.findByUserAndCamp(user, camp);
        if(bookmark != null){
            result = "duplicate";
        } else {
            bookmarkService.saveBookmark(user, camp);
            result = "success";
        }
        return result;
    }

    /*북마크 등록 해제*/
    @DeleteMapping("/bookmark/{id}")
    public void deleteBookmark(@PathVariable(value="id") Long id, HttpServletRequest request){
        User user = userService.getUser(request);
        bookmarkService.deleteByUserAndCamp(user.getId(), id);

        System.out.println("캠핑장 id : " + id + " 북마크 해제");
    }

    /*북마크된 캠핑장 리스트*/
    @GetMapping("/bookmark/ids")
    public List<Long> bookmarkList(HttpServletRequest request){
        User user = userService.getUser(request);
        List<Bookmark> bookmarkList = bookmarkService.findmyBookmark(user.getId());
        List<Long> ids = new ArrayList<>();
        for(Bookmark b : bookmarkList){
            ids.add(b.getCamp().getId());
        }
        return ids;
    }
}
