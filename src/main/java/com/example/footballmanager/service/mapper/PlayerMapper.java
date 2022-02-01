package com.example.footballmanager.service.mapper;

import com.example.footballmanager.dto.request.PlayerRequestDto;
import com.example.footballmanager.dto.response.PlayerResponseDto;
import com.example.footballmanager.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public Player toModel(PlayerRequestDto playerRequestDto) {
        Player player = new Player();
        player.setFirstName(playerRequestDto.getFirstName());
        player.setLastName(playerRequestDto.getLastName());
        player.setBirthDay(playerRequestDto.getBirthDay());
        player.setStartCareer(playerRequestDto.getStartCareer());
        return player;
    }

    public PlayerResponseDto toDto(Player player) {
        PlayerResponseDto playerResponseDto = new PlayerResponseDto();
        playerResponseDto.setId(player.getId());
        playerResponseDto.setFirstName(player.getFirstName());
        playerResponseDto.setLastName(player.getLastName());
        playerResponseDto.setBirthDay(player.getBirthDay());
        playerResponseDto.setStartCareer(player.getStartCareer());
        return playerResponseDto;
    }
}
