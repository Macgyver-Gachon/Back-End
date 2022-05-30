package com.project2022.macgyver.domain.camp;

import com.project2022.macgyver.dto.CampListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Optional;

public interface CampRepository extends JpaRepository<Camp, Long> {
    Optional<Camp> findById(Long id);

    @Query("SELECT p FROM Camp p WHERE p.id=:id")
    Camp findBycampId(@Param("id") Long id);

    @Query("SELECT p FROM Camp p WHERE p.id=:id")
    CampListResponseDto findBycampMark(@Param("id") Long id);

    List<Camp> findAllByIdIn(List<Long> ids);

    @Query("SELECT p FROM Camp p ORDER BY p.id ASC")
    List<Camp> findAllAsc();

    @Query("SELECT c FROM Camp c WHERE "
            +"c.nocar!=0 AND c.clean>=:clean AND c.kids>=:kids AND c.entertainment>=:entertainment AND c.pet!=0 ORDER BY c.score desc")
    List<CampListResponseDto> findRecommendNoOne1(@Param("clean") Double clean,
                                                 @Param("kids") Double kids,
                                                 @Param("entertainment") Double entertainment);

    @Query("SELECT c FROM Camp c WHERE "
            +"c.nocar!=0 AND c.clean>=:clean AND c.kids>=:kids AND c.entertainment>=:entertainment AND c.theme>=:theme ORDER BY c.score desc")
    List<CampListResponseDto> findRecommendNoOne2(@Param("clean") Double clean,
                                                  @Param("kids") Double kids,
                                                  @Param("entertainment") Double entertainment,
                                                  @Param("theme") Double theme);

    @Query("SELECT c FROM Camp c WHERE "
            +"c.clean>=:clean AND c.kids>=:kids AND c.entertainment>=:entertainment AND c.pet!=0 ORDER BY c.score desc")
    List<CampListResponseDto> findRecommendNoOne3(@Param("clean") Double clean,
                                                  @Param("kids") Double kids,
                                                  @Param("entertainment") Double entertainment);

    @Query("SELECT c FROM Camp c WHERE "
            +"c.clean>=:clean AND c.kids>=:kids AND c.entertainment>=:entertainment AND c.theme>=:theme ORDER BY c.score desc")
    List<CampListResponseDto> findRecommendNoOne4(@Param("clean") Double clean,
                                                  @Param("kids") Double kids,
                                                  @Param("entertainment") Double entertainment,
                                                  @Param("theme") Double theme);
}