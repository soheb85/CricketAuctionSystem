package com.cricket.kpl11.repository;

import com.cricket.kpl11.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team,Long> {
}
