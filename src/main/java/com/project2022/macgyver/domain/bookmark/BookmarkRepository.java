package com.project2022.macgyver.domain.bookmark;

import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.BookmarkListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    @Query("SELECT w FROM Bookmark w WHERE w.user.id=:userid AND w.camp.id=:campid")
    Bookmark findByUserAndCamp(@Param("userid") Long userid, @Param("campid") Long campid);

    @Transactional
    @Modifying
    @Query("DELETE FROM Bookmark w WHERE w.user.id=:userid AND w.camp.id=:campid")
    void deleteByUserAndCamp(@Param("userid") Long userid, @Param("campid") Long campid);

    @Query("SELECT p FROM Bookmark p WHERE p.user.id=:userid")
    List<Bookmark> findByUser(@Param("userid") Long userid);

    boolean existsByUser(User user);
}
