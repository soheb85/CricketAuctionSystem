package com.cricket.kpl11.mapper;

import com.cricket.kpl11.dto.PlayerDto;
import com.cricket.kpl11.dto.TeamDto;
import com.cricket.kpl11.entity.Players;
import com.cricket.kpl11.entity.Team;

import java.util.List;
import java.util.stream.Collectors;

//---->> using TeamDto , PlayerDto
public class TeamDtoMapper {

    public static TeamDto mapToTeamDto(Team team){
        return new TeamDto(
                team.getTeamName(),
                team.getPlayerSize(),
                mapToPlayerDto(team.getPlayers())

        );
    }

    public static List<PlayerDto> mapToPlayerDto(List<Players> players){
        return players.stream().map(player->new PlayerDto(
                player.getPlayerId(),
                player.getPlayerName(),
                player.getSoldPrice(),
                player.getIsSold(),
                player.getAvailableToAuction()
        )).collect(Collectors.toList());
    }
}
