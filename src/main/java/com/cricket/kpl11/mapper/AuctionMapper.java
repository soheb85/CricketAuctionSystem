package com.cricket.kpl11.mapper;

import com.cricket.kpl11.dto.GeneratePlayerDto;
import com.cricket.kpl11.entity.Players;

public class AuctionMapper {

    public static GeneratePlayerDto mapToGeneratePlayerDto(Players players){
        return new GeneratePlayerDto(
                players.getPlayerId(),
                players.getPlayerName(),
                players.getPlayerRole(),
                players.getImageUrl()
        );
    }
}
