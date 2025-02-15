package com.cricket.kpl11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//----> Team Service methods getAllTeamsPlayers() for Players Object
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    private Long playerId;
    private String playerName;
    private int soldPrice;
    private boolean isSold;
    private boolean isAvailable;
}
