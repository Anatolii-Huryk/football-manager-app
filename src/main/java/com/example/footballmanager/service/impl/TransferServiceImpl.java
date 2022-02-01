package com.example.footballmanager.service.impl;

import com.example.footballmanager.dao.TransferDao;
import com.example.footballmanager.model.Transfer;
import com.example.footballmanager.service.TransferService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {
    private final TransferDao transferDao;

    public TransferServiceImpl(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    @Override
    public Transfer add(Transfer transfer) {
        return transferDao.save(transfer);
    }

    @Override
    public List<Transfer> getAll() {
        return transferDao.findAll();
    }

    @Override
    public void delete(Long id) {
        transferDao.deleteById(id);
    }

    @Override
    public Transfer get(Long id) {
        return transferDao.getById(id);
    }
}
