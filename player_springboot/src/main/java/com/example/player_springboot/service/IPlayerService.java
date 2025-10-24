package com.example.player_springboot.service;

import com.example.player_springboot.entity.Player;
import com.example.player_springboot.dto.PlayerDTO;
import java.util.List;

public interface IPlayerService {
    List<Player> findAll();
    Player findById(int id);
    boolean add(Player player);
}
