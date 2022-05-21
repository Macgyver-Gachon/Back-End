package com.project2022.macgyver.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserid(String userid);
    User findByUsername(String username);

    @Query("SELECT p FROM User p WHERE p.userid=:userid")
    User findByid(@Param("userid") String userid);

    /* 중복인 경우 true, 중복되지 않은경우 false 리턴 */
    boolean existsByUserid(String userid);
    boolean existsByUsername(String username);

}
