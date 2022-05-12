package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.prefer.Prefer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PreferSaveRequestDto {

    private String q1Walk;
    private String q2Equipment;
    private String q3Shower;
    private String q4Together;
    private String q5Sightseeing;
    private String q6Consider;

    @Builder
    public PreferSaveRequestDto(String q1Walk, String q2Equipment, String q3Shower, String q4Together, String q5Sightseeing, String q6Consider){
        this.q1Walk=q1Walk;
        this.q2Equipment=q2Equipment;
        this.q3Shower=q3Shower;
        this.q4Together=q4Together;
        this.q5Sightseeing=q5Sightseeing;
        this.q6Consider=q6Consider;
    }

    public Prefer toEntity(){
        return Prefer.builder()
                //.user()
                .q1Walk(q1Walk)
                .q2Equipment(q2Equipment)
                .q3Shower(q3Shower)
                .q4Together(q4Together)
                .q5Sightseeing(q5Sightseeing)
                .q6Consider(q6Consider)
                .build();
    }


}