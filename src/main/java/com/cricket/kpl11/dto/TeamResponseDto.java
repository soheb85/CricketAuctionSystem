package com.cricket.kpl11.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDto {
    private Long teamId;
    private String teamName;
    private Integer totalPlayer;
    private Integer maxSpendOnPlayer;
}
