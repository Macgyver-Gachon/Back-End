package com.project2022.macgyver.dto;

import com.project2022.macgyver.domain.prefer.Prefer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PreferSaveRequestDto {

    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private String q6;

    @Builder
    public PreferSaveRequestDto(String q1, String q2, String q3, String q4, String q5, String q6){
        this.q1=q1;
        this.q2=q2;
        this.q3=q3;
        this.q4=q4;
        this.q5=q5;
        this.q6=q6;
    }

    public Prefer toEntity(){
        return Prefer.builder()
                //.user()
                .q1(q1)
                .q2(q2)
                .q3(q3)
                .q4(q4)
                .q5(q5)
                .q6(q6)
                .build();
    }


}