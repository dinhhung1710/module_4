package com.example.player_springboot.repository;

import com.example.player_springboot.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer> {
}
