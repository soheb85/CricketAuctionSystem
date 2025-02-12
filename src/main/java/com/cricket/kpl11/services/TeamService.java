package com.cricket.kpl11.services;

import com.cricket.kpl11.dto.TeamResponseDto;
import com.cricket.kpl11.entity.Team;
import com.cricket.kpl11.exception.NoTeamFoundException;
import com.cricket.kpl11.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TeamRepo teamRepo;

    public void saveTeam(Team team){
        teamRepo.save(team);
    }

    public void deleteAllTeam(){
        teamRepo.deleteAll();

        // Reset auto-increment counter
        jdbcTemplate.execute("ALTER TABLE teams AUTO_INCREMENT = 1");
    }

    public TeamResponseDto sendTeamDetails(Long id){
        Team team = teamRepo.findById(id)
                .orElseThrow(()->new NoTeamFoundException("No Team Found in the Database"));

        return new TeamResponseDto(team.getTeamName(), team.getPlayerSize(), team.getMaxSpendOnPlayer());
    }
}
