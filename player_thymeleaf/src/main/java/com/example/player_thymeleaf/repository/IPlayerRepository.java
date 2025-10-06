package com.example.player_thymeleaf.repository;

import com.example.player_thymeleaf.entity.Player;

import java.util.List;

public interface IPlayerRepository {
    List<Player> findAll();
    Player findById(int id);
    boolean add(Player player);
}