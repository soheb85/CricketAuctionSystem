package com.cricket.kpl11.services;


import com.cricket.kpl11.dto.BidRequestDto;
import com.cricket.kpl11.dto.BidResponseDto;
import com.cricket.kpl11.dto.GeneratePlayerDto;
import com.cricket.kpl11.entity.Players;
import com.cricket.kpl11.entity.Team;
import com.cricket.kpl11.exception.NoPlayerFoundException;
import com.cricket.kpl11.exception.NoTeamFoundException;
import com.cricket.kpl11.mapper.AuctionMapper;
import com.cricket.kpl11.repository.PlayersRepo;
import com.cricket.kpl11.repository.TeamRepo;
import com.cricket.kpl11.utility.GenerateRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuctionServices {

    @Autowired
    private PlayersRepo playersRepo;

    @Autowired
    private TeamRepo teamRepo;

    private Set<Long> alreadyGenerated = new HashSet<>();

    // ---->> Generate Random Player for auction.
    public GeneratePlayerDto sendPlayer(){
        if (alreadyGenerated.size() >= 10) { // If all 4 numbers are used, throw an exception
            throw new RuntimeException("All players have been generated, no more players left.");
        }

        long randomNumber = GenerateRandom.generateRandom();
        while(alreadyGenerated.contains(randomNumber)){

                randomNumber = GenerateRandom.generateRandom();

        }
        alreadyGenerated.add(randomNumber);

        Players generatePlayer = playersRepo.findById(randomNumber)
                .orElseThrow(()-> new NoPlayerFoundException("Player not Found by ID"));

        return AuctionMapper.mapToGeneratePlayerDto(generatePlayer);
    }



    // ------>> Search player by I'd and send generatePlayerDto.
    public GeneratePlayerDto sendPlayerById(Long id){
        Players sendPlayer = playersRepo.findById(id)
                .orElseThrow(()->new NoPlayerFoundException("No Player Found in the database with Player Id"));

        alreadyGenerated.add(id);
        return AuctionMapper.mapToGeneratePlayerDto(sendPlayer);
    }



    // ------>> Bid player services for every player and every team.
    // ------>> For Sold PLayer
    public BidResponseDto bidPlayer(BidRequestDto bidRequestDto){

        Players players = playersRepo.findById(bidRequestDto.getPlayerId())
                .orElseThrow(()->new NoPlayerFoundException("No Player Found"));

        Team team = teamRepo.findById(bidRequestDto.getTeamId())
                .orElseThrow(()->new NoTeamFoundException("No Team Found In Database"));

        if(team.getRemainingPoint()<bidRequestDto.getSoldPrice()){
            return new BidResponseDto("Insufficient Point to buy the player");
        }

        if(team.getMaxSpendOnPlayer()<bidRequestDto.getSoldPrice()){
            return new BidResponseDto("Cannot to sold Player to this team because it doesn't have max Spend On player");
        }

        if(players.getIsSold()){
            return new BidResponseDto("Player Already Sold");
        }

        if(team.getPlayerSize()>15){
            return new BidResponseDto("You cannot buy more Player maximum is 15 player");
        }

        //Assign Player to the Team
        players.setTeam(team);
        players.setSoldPrice(bidRequestDto.getSoldPrice());
        players.setSold(true);
        players.setAvailableToAuction(false);

        // calculate the remaining point to buy players
        team.setRemainingPoint(team.getRemainingPoint()- bidRequestDto.getSoldPrice());

        playersRepo.save(players);
        teamRepo.save(team);

        //calculate the total player in the team
        int playerCount = team.getPlayerSize();

        System.out.println("This is the Player Count ----------------------============>>>>>>>>>  "+playerCount);

        // calculate the maximum point spend on the player
        team.setMaxSpendOnPlayer(team.getRemainingPoint()-((12-playerCount)*players.getBasePrice()));
        System.out.println("This is max spend Calculated   -->>>>   "+team.getMaxSpendOnPlayer());
        teamRepo.save(team);

        return new BidResponseDto("Bidding Successfully");
    }

    // ------>> Bid player services for every player and every team.
    // ------>> For UnSold PLayer

    public void unsoldBid(Long id){
        Players players = playersRepo.findById(id)
                .orElseThrow(()->new NoPlayerFoundException("No Player Found"));
        players.setAvailableToAuction(false);
        playersRepo.save(players);
    }

}
