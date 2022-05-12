package com.project2022.macgyver.domain.prefer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreferRepository extends JpaRepository<Prefer, Long> {
    Optional<Prefer> findByUser_userid(String userid);
    boolean existsByUser_userid(String userid);
}
