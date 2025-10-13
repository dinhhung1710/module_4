package com.example.player_springboot.service;

import com.example.player_springboot.entity.Team;

import java.util.List;

public interface ITeamService {
    List<Team> findAll();
    Team findById(int id);
    boolean save(Team team);
    void delete(int id);
}
