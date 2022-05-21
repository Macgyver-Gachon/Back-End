package com.project2022.macgyver.service;

import com.project2022.macgyver.domain.bookmark.Bookmark;
import com.project2022.macgyver.domain.bookmark.BookmarkRepository;
import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;

    @Transactional(readOnly = true)
    public Bookmark findByUserAndCamp(User user, Camp camp){
        return bookmarkRepository.findByUserAndCamp(user.getId(), camp.getId());
    }

    @Transactional
    public void saveBookmark(User user, Camp camp){
        Bookmark bookmark = new Bookmark();
        bookmark.setUser(user);
        bookmark.setCamp(camp);
        bookmarkRepository.save(bookmark);
    }

    @Transactional
    public void deleteByUserAndCamp(Long userid, Long campid){
        bookmarkRepository.deleteByUserAndCamp(userid, campid);
    }

}
