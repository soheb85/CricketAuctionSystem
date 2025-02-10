package com.cricket.kpl11.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuctionRequestDTO {

    private Long PlayerId;
    private int soldPrice;
    private Long teamId;
}
