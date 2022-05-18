package com.project2022.macgyver.domain.camp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CampRepository extends JpaRepository<Camp, Long>{
    Camp findCampById(Long id);
}