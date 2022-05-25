package com.project2022.macgyver.service;

import com.project2022.macgyver.domain.bookmark.Bookmark;
import com.project2022.macgyver.domain.bookmark.BookmarkRepository;
import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.BookmarkListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;

    /*북마크 등록 여부 확인*/
    @Transactional(readOnly = true)
    public Bookmark findByUserAndCamp(User user, Camp camp){
        return bookmarkRepository.findByUserAndCamp(user.getId(), camp.getId());
    }

    /*북마크 등록*/
    @Transactional
    public void saveBookmark(User user, Camp camp){
        Bookmark bookmark = new Bookmark();
        bookmark.setUser(user);
        bookmark.setCamp(camp);
        bookmarkRepository.save(bookmark);
    }

    /*북마크 해제*/
    @Transactional
    public void deleteByUserAndCamp(Long userid, Long campid){
        bookmarkRepository.deleteByUserAndCamp(userid, campid);
    }

    /*특정 사용자의 북마크 리스트*/
    @Transactional
    public List<Bookmark> findmyBookmark(Long id){
        return bookmarkRepository.findByUser(id);
    }
}
