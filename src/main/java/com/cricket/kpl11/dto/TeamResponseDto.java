package com.cricket.kpl11.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamResponseDto {
    private String teamName;
    private Integer totalPlayer;
    private Integer maxSpendOnPlayer;
}
