package com.example.player_thymeleaf.repository;

import com.example.player_thymeleaf.entity.Player;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepository implements IPlayerRepository {
    private static List<Player> playerList = new ArrayList<>();
    private static int nextId = 2;

    static {
        playerList.add(new Player(1, "Thái Đình Hùng", LocalDate.of(1997, 10, 17), "5", "Tiền đạo",
                "https://i.pinimg.com/736x/c6/e5/65/c6e56503cfdd87da299f72dc416023d4.jpg"
        ));
    }
    @Override
    public List<Player> findAll() {
        return playerList;
    }
    @Override
    public void add(Player player) {
        if (player.getId() == 0) {
            player.setId(nextId++);
        }
        playerList.add(player);
    }
    @Override
    public void delete(int id) {
        playerList.removeIf(player -> player.getId() == id);
    }
}
