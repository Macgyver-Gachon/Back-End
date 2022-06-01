package com.project2022.macgyver.domain.posts;

import com.project2022.macgyver.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Modifying // @Query로 작성된 조회를 제외한 데이터의 변경이 일어나는 쿼리 메서드를 사용할 때 필요
    @Query("update Posts p set p.view = p.view + 1 where p.id = :id")
    int updateView(Long id);

    Page<Posts> findByTitleContaining(String keyword, Pageable pageable);

    List<Posts> findByUser(User user);
}