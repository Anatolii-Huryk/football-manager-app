package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.PlayerRequestDto;
import com.example.footballmanager.dto.response.PlayerResponseDto;
import com.example.footballmanager.service.PlayerService;
import com.example.footballmanager.service.mapper.PlayerMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    public PlayerController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @PostMapping("/add")
    public PlayerResponseDto add(@RequestBody PlayerRequestDto playerRequestDto) {
        return playerMapper.toDto(playerService.add(playerMapper.toModel(playerRequestDto)));
    }

    @PostMapping("/add_all")
    public List<PlayerResponseDto> addAll(@RequestBody List<PlayerRequestDto> playerRequestDtos) {
        return playerRequestDtos.stream()
                .map(playerMapper::toModel)
                .map(playerService::add)
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PlayerResponseDto get(@PathVariable Long id) {
        return playerMapper.toDto(playerService.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.delete(id);
    }
}
