package com.cricket.kpl11.controller;


import com.cricket.kpl11.dto.BidRequestDto;
import com.cricket.kpl11.dto.BidResponseDto;
import com.cricket.kpl11.dto.GeneratePlayerDto;
import com.cricket.kpl11.services.AuctionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/generate/{id}")
    public ResponseEntity<GeneratePlayerDto> sendPalyerById(@PathVariable Long id){
        GeneratePlayerDto generatePlayerDto = auctionServices.sendPlayerById(id);
        return ResponseEntity.ok(generatePlayerDto);
    }

    @PostMapping("/bid")
    public ResponseEntity<BidResponseDto> bidPlayer(@RequestBody BidRequestDto bidRequestDto){
        BidResponseDto bidResponseDto = auctionServices.bidPlayer(bidRequestDto);
        return ResponseEntity.ok(bidResponseDto);
    }
}
