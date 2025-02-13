package com.cricket.kpl11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummaryTeamDto {

    private Long teamId;
    private String teamName;
    private int remainingPoint;
    private int maxSpendOnPlayer;
    private int totalPlayer;
}
