package com.project2022.macgyver.domain.admin;

import com.project2022.macgyver.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    List<User> findByEmailContaining(String keyword);

    @Query("SELECT p FROM User p ORDER BY p.id DESC")
    List<User> findAllDesc();
}
