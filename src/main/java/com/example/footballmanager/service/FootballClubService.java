package com.example.footballmanager.service;

import com.example.footballmanager.model.FootballClub;
import java.util.List;

public interface FootballClubService {
    FootballClub add(FootballClub footballClub);

    FootballClub get(Long id);

    List<FootballClub> getAll();

    void delete(Long id);

    void transfer(Long playerID,
                  Long sellingFootballClub,
                  Long buyingFootballClub);
}
