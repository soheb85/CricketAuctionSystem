package com.cricket.kpl11.services;


import com.cricket.kpl11.dto.GeneratePlayerDto;
import com.cricket.kpl11.entity.Players;
import com.cricket.kpl11.mapper.AuctionMapper;
import com.cricket.kpl11.repository.PlayersRepo;
import com.cricket.kpl11.utility.GenerateRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuctionServices {

    @Autowired
    private PlayersRepo playersRepo;

    private Set<Long> alreadyGenerated = new HashSet<>();

    // ---->> Generate Random Player for auction.
    public GeneratePlayerDto sendPlayer(){
        if (alreadyGenerated.size() >= 4) { // If all 4 numbers are used, throw an exception
            throw new RuntimeException("All players have been generated, no more players left.");
        }

        long randomNumber = GenerateRandom.generateRandom();
        while(alreadyGenerated.contains(randomNumber)){

                randomNumber = GenerateRandom.generateRandom();

        }
        alreadyGenerated.add(randomNumber);

        Players generatePlayer = playersRepo.findById(randomNumber)
                .orElseThrow(()-> new RuntimeException("Player not Found by ID"));

        return AuctionMapper.mapToGeneratePlayerDto(generatePlayer);
    }

    // ------>> Search player by I'd and send generatePlayerDto.



}
