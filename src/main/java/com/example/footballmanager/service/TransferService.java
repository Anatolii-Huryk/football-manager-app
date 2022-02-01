package com.example.footballmanager.service;

import com.example.footballmanager.model.Transfer;
import java.util.List;

public interface TransferService {
    Transfer add(Transfer transfer);

    List<Transfer> getAll();

    void delete(Long id);

    Transfer get(Long id);
}
