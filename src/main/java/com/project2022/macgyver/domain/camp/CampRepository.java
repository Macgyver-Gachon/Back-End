package com.project2022.macgyver.domain.camp;

import com.project2022.macgyver.dto.CampListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CampRepository extends JpaRepository<Camp, Long>{
    Optional<Camp> findById(Long id);

    @Query("SELECT p FROM Camp p WHERE p.id=:id")
    Camp findBycampId(@Param("id") Long id);

    @Query("SELECT p FROM Camp p WHERE p.id=:id")
    CampListResponseDto findBycampMark(@Param("id") Long id);

    List<Camp> findAllByIdIn(List<Long> ids);

    @Query("SELECT p FROM Camp p ORDER BY p.id ASC")
    List<Camp> findAllAsc();

}