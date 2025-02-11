package com.cricket.kpl11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TeamId;

    private String teamName;

    private int totalPoint = 10000;

    private int remainingPoint = 10000;

    private int maxSpendOnPlayer = 6400;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Players> players = new ArrayList<>();

    public int getPlayerSize(){
        return players.size();
    }
}
