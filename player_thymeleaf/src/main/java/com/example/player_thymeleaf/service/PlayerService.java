package com.example.player_thymeleaf.service;

import com.example.player_thymeleaf.entity.Player;
import com.example.player_thymeleaf.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService{
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public void add(Player player) {
        playerRepository.add(player);
    }

    @Override
    public void delete(int id) {
        playerRepository.delete(id);
    }
}
