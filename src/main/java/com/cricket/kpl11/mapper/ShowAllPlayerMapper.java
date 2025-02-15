package com.cricket.kpl11.mapper;

import com.cricket.kpl11.dto.ShowAllPlayerDto;
import com.cricket.kpl11.entity.Players;
import com.cricket.kpl11.entity.Team;

import java.util.Optional;

public class ShowAllPlayerMapper {

    public static ShowAllPlayerDto mapToShowAllPLayerDto(Players players){
        return new ShowAllPlayerDto(
                players.getPlayerId(),
                players.getPlayerName(),
                players.getSoldPrice(),
                players.getIsSold(),
                players.getAvailableToAuction(),
                players.getImageUrl(),
                getTeamName(players.getTeam())
        );
    }

    public static String getTeamName(Team team){
        return (team != null && team.getTeamName() != null) ? team.getTeamName() : "";
    }
}
