package com.example.player_springboot.service;

import com.example.player_springboot.entity.Team;
import com.example.player_springboot.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ITeamService{
    @Autowired
    private ITeamRepository teamRepository;

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(int id) {
        return teamRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Team team) {
        return teamRepository.save(team) != null;
    }

    @Override
    public void delete(int id) {
        teamRepository.deleteById(id);
    }
}
