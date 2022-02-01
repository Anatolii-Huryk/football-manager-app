package com.example.footballmanager.service.mapper;

import com.example.footballmanager.dto.request.FootballClubRequestDto;
import com.example.footballmanager.dto.response.FootballClubResponseDto;
import com.example.footballmanager.model.FootballClub;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.PlayerService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FootballClubMapper {
    private final PlayerService playerService;

    public FootballClubMapper(PlayerService playerService) {
        this.playerService = playerService;
    }

    public FootballClub toModel(FootballClubRequestDto footballClubRequestDto) {
        FootballClub footballClub = new FootballClub();
        footballClub.setName(footballClubRequestDto.getName());
        footballClub.setCity(footballClubRequestDto.getCity());
        footballClub.setBalance(footballClubRequestDto.getBalance());
        footballClub.setCommission(footballClubRequestDto.getCommission());
        footballClub.setPlayers(footballClubRequestDto.getPlayersId().stream()
                .map(playerService::get)
                .collect(Collectors.toList()));
        footballClub.setCountry(footballClubRequestDto.getCountry());
        return footballClub;
    }

    public FootballClubResponseDto toDto(FootballClub footballClub) {
        FootballClubResponseDto footballClubResponseDto = new FootballClubResponseDto();
        footballClubResponseDto.setId(footballClub.getId());
        footballClubResponseDto.setName(footballClub.getName());
        footballClubResponseDto.setCity(footballClub.getCity());
        footballClubResponseDto.setCommission(footballClub.getCommission());
        footballClubResponseDto.setBalance(footballClub.getBalance());
        footballClubResponseDto.setCountry(footballClub.getCountry());
        footballClubResponseDto.setPlayersId(footballClub.getPlayers().stream()
                .map(Player::getId)
                .collect(Collectors.toList()));
        return footballClubResponseDto;
    }
}
