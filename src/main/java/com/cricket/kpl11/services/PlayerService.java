package com.cricket.kpl11.services;


import com.cricket.kpl11.dto.ShowAllPlayerDto;
import com.cricket.kpl11.entity.Players;
import com.cricket.kpl11.mapper.ShowAllPlayerMapper;
import com.cricket.kpl11.repository.PlayersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PlayersRepo playersRepo;

    public void savePlayer(Players players){
        Players savePlayers = playersRepo.save(players);

        savePlayers.setImageUrl(String.valueOf(savePlayers.getPlayerId()));

        playersRepo.save(savePlayers);

    }

    public void deleteAllPlayer(){
        playersRepo.deleteAll();

        // Reset auto-increment counter
        jdbcTemplate.execute("ALTER TABLE players AUTO_INCREMENT = 1");

    }

    public List<ShowAllPlayerDto> getAllPlayer(){
       return playersRepo.findAll()
                .stream()
                .map(ShowAllPlayerMapper::mapToShowAllPLayerDto).collect(Collectors.toList());
    }
}
