package com.project2022.macgyver.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(String id);
    User findByEmail(String email);
//    Optional<User> findByUserid(String userid);
//    User findByUsername(String username);
//
//    /* 중복인 경우 true, 중복되지 않은경우 false 리턴 */
//    boolean existsByUserid(String userid);
//    boolean existsByUsername(String username);

}
