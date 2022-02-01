package com.example.footballmanager.service;

import com.example.footballmanager.model.Player;

public interface PlayerService {
    Player add(Player player);

    Player get(Long id);

    void delete(Long id);
}
