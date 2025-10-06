
package com.example.player_thymeleaf.service;

import com.example.player_thymeleaf.entity.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();
    Player findById(int id);
    void add(Player player);
}
