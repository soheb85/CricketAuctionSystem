package com.cricket.kpl11.controller;


import com.cricket.kpl11.dto.ShowAllPlayerDto;
import com.cricket.kpl11.entity.Players;
import com.cricket.kpl11.mapper.ShowAllPlayerMapper;
import com.cricket.kpl11.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@CrossOrigin("*")
public class PlayersController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/registration")
    public ResponseEntity<String> savePlayer(@RequestBody Players players){
        playerService.savePlayer(players);
        return ResponseEntity.ok("Saved Player Successfully for the Auction");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllPlayer(){
        playerService.deleteAllPlayer();
        return ResponseEntity.ok("All Data Deleted From Player Table");
    }

    @GetMapping("/allPlayer")
    public ResponseEntity<List<ShowAllPlayerDto>> getAllPlayer(){
        List<ShowAllPlayerDto> showAllPlayerMapper = playerService.getAllPlayer();
        return ResponseEntity.ok(showAllPlayerMapper);
    }
}
