package com.example.player_thymeleaf.repository;

import com.example.player_thymeleaf.entity.Player;

import java.util.List;

public interface IPlayerRepository {
    List<Player> findAll();
    void add(Player player);
    void delete(int id);
}
