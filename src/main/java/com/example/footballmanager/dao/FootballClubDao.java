package com.example.footballmanager.dao;

import com.example.footballmanager.model.FootballClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballClubDao extends JpaRepository<FootballClub, Long> {
}
