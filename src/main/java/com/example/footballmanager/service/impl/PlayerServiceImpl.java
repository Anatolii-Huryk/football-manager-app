package com.example.footballmanager.service.impl;

import com.example.footballmanager.dao.PlayerDao;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerDao playerDao;

    public PlayerServiceImpl(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Override
    public Player add(Player player) {
        return playerDao.save(player);
    }

    @Override
    public Player get(Long id) {
        return playerDao.getById(id);
    }

    @Override
    public void delete(Long id) {
        playerDao.deleteById(id);
    }
}
