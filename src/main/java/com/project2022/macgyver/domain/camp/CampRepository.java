package com.project2022.macgyver.domain.camp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CampRepository extends JpaRepository<Camp, Long>{
    Optional<Camp> findById(Long id);

    List<Camp> findAllByIdIn(List<Long> ids);
}