package com.cricket.kpl11.dto;

import com.cricket.kpl11.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowAllPlayerDto {

    private Long playerId;
    private String playerName;
    private int soldPrice;
    private boolean isSold;
    private boolean isAvailable;
    private String imageUrl;
    private String teamName;
}
