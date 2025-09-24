package com.example.bai_tap.repository;

import com.example.bai_tap.entity.Player;

import java.util.List;

public interface IPlayerRepository {
    List<Player> findAll();
    void add(Player player);
    void delete(int id);
}
