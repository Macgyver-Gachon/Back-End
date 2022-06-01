package com.project2022.macgyver.domain.posts;

import com.project2022.macgyver.domain.camp.Camp;
import com.project2022.macgyver.domain.user.User;
import com.project2022.macgyver.dto.PostsListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<PostsListResponseDto> findAllAsc();

    Page<Posts> findByTitleContaining(String keyword, Pageable pageable);

    @Query("SELECT p FROM Posts p WHERE p.user.id=:userid")
    List<PostsListResponseDto> findByUserid(@Param("userid") Long userid);
}