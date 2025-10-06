package com.example.player_thymeleaf.repository;

import com.example.player_thymeleaf.entity.Player;
import com.example.player_thymeleaf.utils.ConnectionUtil;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepository implements IPlayerRepository {
    @Override
    public List<Player> findAll() {
        List <Player> playerList = new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Player> query = session.createQuery("from Player");
        playerList = query.getResultList();
        session.close();
        return playerList;
    }
    @Override
    public Player findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Player player = session.find(Player.class, id);
        session.close();
        return player;
    }
    @Override
    public boolean add(Player player) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            transaction.begin();
            session.persist(player);
            transaction.commit();
        }  catch (Exception e) {
            transaction.rollback();
            return false;
        }
        return true;
    }
}