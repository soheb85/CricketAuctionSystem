package com.cricket.kpl11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "players")
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long PlayerId;

    private String PlayerName;

    private String PlayerRole;

    private String imageUrl;

    private int basePrice = 300;

    private int soldPrice;

    private boolean availableToAuction = true;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private boolean isSold;

    public boolean getIsSold(){
        return isSold;
    }

    public boolean getAvailableToAuction(){
        return availableToAuction;
    }
}
