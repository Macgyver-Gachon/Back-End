package com.project2022.macgyver.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CampListSaveRequestDto {

    List<CampSaveRequestDto> item = new ArrayList<>();
}