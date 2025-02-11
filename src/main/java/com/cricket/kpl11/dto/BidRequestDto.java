package com.cricket.kpl11.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidRequestDto {

    private Long PlayerId;
    private Integer soldPrice;
    private Long teamId;
}
