package com.cricket.kpl11.services;

import com.cricket.kpl11.dto.SummaryTeamDto;
import com.cricket.kpl11.entity.Team;
import com.cricket.kpl11.mapper.SummaryMapper;
import com.cricket.kpl11.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SummaryTeamService {

    @Autowired
    private TeamRepo teamRepo;

    public List<SummaryTeamDto> allTeamSummary(){
        List<Team> teams = teamRepo.findAll();
        return teams.stream().map(SummaryMapper::mapToSummaryTeamDto).collect(Collectors.toList());
    }
}
