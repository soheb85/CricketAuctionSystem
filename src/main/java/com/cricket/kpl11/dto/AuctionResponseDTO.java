package com.cricket.kpl11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuctionResponseDTO {
    private String playerName;
    private String teamName;
    private int soldPrice;
}
