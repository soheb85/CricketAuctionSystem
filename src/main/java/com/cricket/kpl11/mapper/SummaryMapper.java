package com.cricket.kpl11.mapper;

import com.cricket.kpl11.dto.SummaryTeamDto;
import com.cricket.kpl11.entity.Team;

public class SummaryMapper {
    public static SummaryTeamDto mapToSummaryTeamDto(Team team){
        return new SummaryTeamDto(
                team.getTeamId(),
                team.getTeamName(),
                team.getRemainingPoint(),
                team.getMaxSpendOnPlayer(),
                team.getPlayerSize()
        );
    }
}
