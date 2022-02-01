package com.example.footballmanager.service.impl;

import com.example.footballmanager.dao.FootballClubDao;
import com.example.footballmanager.dao.PlayerDao;
import com.example.footballmanager.model.FootballClub;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.model.Transfer;
import com.example.footballmanager.service.FootballClubService;
import com.example.footballmanager.service.TransferService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FootballClubServiceImpl implements FootballClubService {
    private final FootballClubDao footballClubDao;
    private final PlayerDao playerDao;
    private final TransferService transferService;
    private static final Long CONSTANT_OPERATION_PLAYER = 100000L;

    public FootballClubServiceImpl(FootballClubDao footballClubDao, PlayerDao playerDao, TransferService transferService) {
        this.footballClubDao = footballClubDao;
        this.playerDao = playerDao;
        this.transferService = transferService;
    }

    @Override
    public FootballClub add(FootballClub footballClub) {
        return footballClubDao.save(footballClub);
    }

    @Override
    public FootballClub get(Long id) {
        return footballClubDao.getById(id);
    }

    @Override
    public List<FootballClub> getAll() {
        return footballClubDao.findAll();
    }

    @Override
    public void delete(Long id) {
        footballClubDao.deleteById(id);
    }
    @Override
    public void transfer(Long playerID, Long sellingFootballClub, Long buyingFootballClub) {
        Player player = playerDao.getById(playerID);
        FootballClub sellingClub = footballClubDao.getById(sellingFootballClub);
        FootballClub buyingClub = footballClubDao.getById(buyingFootballClub);

        BigDecimal priceTransfer = BigDecimal.valueOf(player.getStartCareer().getMonth().getValue()
                * CONSTANT_OPERATION_PLAYER /
                (LocalDate.now().getYear() - player.getBirthDay().getYear()));
        BigDecimal commission = priceTransfer.multiply(BigDecimal.valueOf(sellingClub.getCommission()));

        sellingClub.setBalance(sellingClub.getBalance().add(priceTransfer).add(commission));
        sellingClub.getPlayers().remove(player);
        buyingClub.setBalance(buyingClub.getBalance().subtract(priceTransfer).subtract(commission));
        buyingClub.getPlayers().add(player);

        Transfer transfer = new Transfer();
        transfer.setPlayer(player);
        transfer.setFootballClub(sellingClub);
        transfer.setPrice(priceTransfer);

        transferService.add(transfer);
        footballClubDao.save(sellingClub);
        footballClubDao.save(buyingClub);
    }

}
