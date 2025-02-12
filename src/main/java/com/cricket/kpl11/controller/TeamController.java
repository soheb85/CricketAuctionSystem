package com.cricket.kpl11.controller;


import com.cricket.kpl11.dto.TeamResponseDto;
import com.cricket.kpl11.entity.Team;
import com.cricket.kpl11.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.TemporalAccessor;

@RestController
@RequestMapping("/team")
@CrossOrigin("*")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/save")
    public ResponseEntity<String> saveTeam(@RequestBody Team team){
        teamService.saveTeam(team);
        return ResponseEntity.ok("Saved Team Successfully for the Auctions ");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllTeam(){
        teamService.deleteAllTeam();
        return ResponseEntity.ok("Delete All from team Table");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDto> sendTeamDetails(@PathVariable Long id){
        TeamResponseDto teamResponseDto = teamService.sendTeamDetails(id);
        return ResponseEntity.ok(teamResponseDto);
    }
}
