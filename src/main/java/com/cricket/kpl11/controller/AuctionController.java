package com.cricket.kpl11.controller;


import com.cricket.kpl11.dto.GeneratePlayerDto;
import com.cricket.kpl11.services.AuctionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auction")
public class AuctionController {

    @Autowired
    private AuctionServices auctionServices;

    @GetMapping("/generate")
    public ResponseEntity<GeneratePlayerDto> sendPlayer(){
        GeneratePlayerDto generatePlayerDto = auctionServices.sendPlayer();
        return ResponseEntity.ok(generatePlayerDto);
    }
}
