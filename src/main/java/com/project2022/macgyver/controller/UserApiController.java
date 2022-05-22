package com.project2022.macgyver.controller;

import com.project2022.macgyver.config.auth.dto.SessionUser;
import com.project2022.macgyver.domain.bookmark.Bookmark;
import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.BookmarkListResponseDto;
import com.project2022.macgyver.dto.CampListResponseDto;
import com.project2022.macgyver.dto.UserResponseDto;
import com.project2022.macgyver.service.BookmarkService;
import com.project2022.macgyver.service.CampService;
import com.project2022.macgyver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;
    private final BookmarkService bookmarkService;
    private final CampService campService;
    private final HttpSession httpSession;

    //내 정보 보기
    @GetMapping("/user/mypage")
    public UserResponseDto findUserInfo(String userid){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return userService.findByUserid(user.getUserid());
    }

    //회원탈퇴
    @DeleteMapping("/user/mypage")
    public void delete(String userid) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        userService.delete(user.getUserid());
    }

    /*내가 쓴 글 조회*/
    //@GetMapping("user/mypage/post")

    /*나의 북마크 조회*/

    @GetMapping("user/mypage/bookmark")
    public List<CampListResponseDto> myBookmark(){
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");
        User user = userService.findByid(sessionUser.getUserid());
        List<Bookmark> bookmarkList = bookmarkService.findmyBookmark(user.getId());
        List<CampListResponseDto> campList = new ArrayList<>();
        for(Bookmark b : bookmarkList){
            campList.add(campService.findBycampMark(b.getCamp().getId()));
        }
        return campList;
        /*
        List<Camp> campList = new ArrayList<>();
        for(Bookmark b : bookmarkList){
            campList.add(campService.findBycampId(b.getCamp().getId()));
        }
        return campList;
        * */
    }

    /*
    @DeleteMapping("/user/mypage/{userid}")
    public String delete(@PathVariable String userid) {
        userService.delete(userid);
        return userid;
    }
    */

}
