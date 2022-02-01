package com.example.footballmanager.dao;

import com.example.footballmanager.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferDao extends JpaRepository<Transfer, Long> {
}
