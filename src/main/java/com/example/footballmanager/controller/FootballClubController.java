package com.example.footballmanager.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.example.footballmanager.dto.request.FootballClubRequestDto;
import com.example.footballmanager.dto.response.FootballClubResponseDto;
import com.example.footballmanager.service.FootballClubService;
import com.example.footballmanager.service.mapper.FootballClubMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/football_clubs")
public class FootballClubController {
    private final FootballClubService footballClubService;
    private final FootballClubMapper footballClubMapper;

    public FootballClubController(FootballClubService footballClubService,
                                  FootballClubMapper footballClubMapper) {
        this.footballClubService = footballClubService;
        this.footballClubMapper = footballClubMapper;
    }

    @PostMapping("/add/one")
    public FootballClubResponseDto add(@RequestBody
                                               FootballClubRequestDto footballClubRequestDto) {
        return footballClubMapper.toDto(footballClubService.add(footballClubMapper
                .toModel(footballClubRequestDto)));
    }

    @PostMapping("/add/all")
    public List<FootballClubResponseDto> addAll(@RequestBody
                                                List<FootballClubRequestDto> footballClubRequestDtos) {
        return footballClubRequestDtos.stream()
                .map(footballClubMapper::toModel)
                .map(footballClubService::add)
                .map(footballClubMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public FootballClubResponseDto get(@PathVariable Long id) {
        return footballClubMapper.toDto(footballClubService.get(id));
    }

    @GetMapping("/all")
    public List<FootballClubResponseDto> getAll() {
        return footballClubService.getAll().stream()
                .map(footballClubMapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        footballClubService.delete(id);
    }

    @PutMapping("/transfer")
    public List<FootballClubResponseDto> transfer(@RequestParam Long playerID,
                                              @RequestParam Long sellingFootballClub,
                                              @RequestParam Long buyingFootballClub) {
        footballClubService.transfer(playerID, sellingFootballClub, buyingFootballClub);
        return footballClubService.getAll().stream()
                .map(footballClubMapper::toDto)
                .collect(Collectors.toList());
    }
}
