package com.cricket.kpl11.repository;

import com.cricket.kpl11.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepo extends JpaRepository<Players,Long> {
}
