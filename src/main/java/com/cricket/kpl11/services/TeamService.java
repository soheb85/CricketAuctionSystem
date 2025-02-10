package com.cricket.kpl11.services;

import com.cricket.kpl11.entity.Team;
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
}
