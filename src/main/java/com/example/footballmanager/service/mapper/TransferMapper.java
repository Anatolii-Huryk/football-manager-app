package com.example.footballmanager.service.mapper;

import com.example.footballmanager.dto.request.TransferRequestDto;
import com.example.footballmanager.dto.response.TransferResponseDto;
import com.example.footballmanager.model.Transfer;
import com.example.footballmanager.service.FootballClubService;
import com.example.footballmanager.service.PlayerService;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper {
    private final PlayerService playerService;
    private final FootballClubService footballClubService;

    public TransferMapper(PlayerService playerService, FootballClubService footballClubService) {
        this.playerService = playerService;
        this.footballClubService = footballClubService;
    }

    public Transfer toModel(TransferRequestDto transferRequestDto) {
        Transfer transfer = new Transfer();
        transfer.setPrice(transferRequestDto.getPrice());
        transfer.setPlayer(playerService.get(transferRequestDto.getPlayerId()));
        transfer.setFootballClub(footballClubService.get(
                transferRequestDto.getFootballClubId()));
        return transfer;
    }

    public TransferResponseDto toDto(Transfer transfer) {
        TransferResponseDto transferResponseDto = new TransferResponseDto();
        transferResponseDto.setId(transfer.getId());
        transferResponseDto.setPrice(transfer.getPrice());
        transferResponseDto.setFootballClubId(transfer.getPlayer().getId());
        transferResponseDto.setPlayerId(transfer.getId());
        return transferResponseDto;
    }
}
