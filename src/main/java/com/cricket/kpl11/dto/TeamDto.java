package com.cricket.kpl11.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//----> Team Service methods getAllTeamsPlayers() for Team Object
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDto {
    private String teamName;
    private int totalPlayer;
    private List<PlayerDto> playerDto;
}
