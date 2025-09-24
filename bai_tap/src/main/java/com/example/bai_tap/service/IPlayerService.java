package com.example.bai_tap.service;

import com.example.bai_tap.entity.Player;

import java.util.List;

public interface IPlayerService {
    List<Player> findAll();
    void add(Player player);
    void delete(int id);
}
