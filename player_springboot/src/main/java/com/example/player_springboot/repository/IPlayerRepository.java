package com.example.player_springboot.repository;

import com.example.player_springboot.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerRepository extends JpaRepository<Player,Integer> {
}
