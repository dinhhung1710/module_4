package com.example.bai_tap.service;

import com.example.bai_tap.entity.Player;
import com.example.bai_tap.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {

    @Autowired
    private IPlayerRepository playerRepository;

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
