package com.cricket.kpl11.repository;

import com.cricket.kpl11.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlayersRepo extends JpaRepository<Players,Long> {


    List<Players> findByIsSoldFalse();
}
