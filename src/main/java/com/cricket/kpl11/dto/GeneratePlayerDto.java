package com.cricket.kpl11.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneratePlayerDto {
    private Long PlayerID;
    private String PlayerName;
    private String PlayerRole;
    private String imageUrl;

}
