package com.example.player_springboot.service;

import com.example.player_springboot.entity.Player;
import com.example.player_springboot.dto.PlayerDTO;
import com.example.player_springboot.entity.Team;
import com.example.player_springboot.repository.IPlayerRepository;
import com.example.player_springboot.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PlayerService implements IPlayerService{
    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findById(int id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean add(PlayerDTO playerDTO) {
        Team team = teamRepository.findById(playerDTO.getTeamId()).orElseThrow(()
                -> new IllegalArgumentException("Team Not Found"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        playerDTO.setFullName(playerDTO.getFullName());
        playerDTO.setDayOfBirth(playerDTO.getDayOfBirth(), formatter);
        playerDTO.setExperience(playerDTO.getExperience());
        playerDTO.setPosition(playerDTO.getPosition());
        playerDTO.setAvatar(playerDTO.getAvatar());
        playerDTO.setTeamId(playerDTO.getTeamId());

        return playerRepository.save(playerDTO) != null;
    }

}
