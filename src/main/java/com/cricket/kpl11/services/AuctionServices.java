package com.cricket.kpl11.services;


import com.cricket.kpl11.dto.GeneratePlayerDto;
import com.cricket.kpl11.entity.Players;
import com.cricket.kpl11.mapper.AuctionMapper;
import com.cricket.kpl11.repository.PlayersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AuctionServices {

    @Autowired
    private PlayersRepo playersRepo;

    private Random random = new Random();

    // ---->> Generate Random Player for auction.
    public GeneratePlayerDto sendPlayer(){
        List<Players> generatePlayer = playersRepo.findByIsSoldFalse();
        if(generatePlayer.isEmpty()){
            throw new RuntimeException("No Player Available to Generate");
        }
        Players sendPlayers = generatePlayer.get(random.nextInt(generatePlayer.size()));
        return AuctionMapper.mapToGeneratePlayerDto(sendPlayers);
    }

    // ------>> Search player by Id and send generatePlayerDto.



}
