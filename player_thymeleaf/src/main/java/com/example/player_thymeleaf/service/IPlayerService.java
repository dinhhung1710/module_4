package com.example.player_thymeleaf.service;

import com.example.player_thymeleaf.entity.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();
    void add(Player player);
    void delete(int id);
}
