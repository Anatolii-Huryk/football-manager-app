package com.example.footballmanager.controller;

import com.example.footballmanager.dto.request.TransferRequestDto;
import com.example.footballmanager.dto.response.TransferResponseDto;
import com.example.footballmanager.service.TransferService;
import com.example.footballmanager.service.mapper.TransferMapper;
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
@RequestMapping("/transfers")
public class TransferController {
    private final TransferMapper transferMapper;
    private final TransferService transferService;

    public TransferController(TransferMapper transferMapper,
                              TransferService transferService) {
        this.transferMapper = transferMapper;
        this.transferService = transferService;
    }

    @PostMapping("/add")
    public TransferResponseDto add(@RequestBody TransferRequestDto transferRequestDto) {
        return transferMapper.toDto(transferService.add(transferMapper
                .toModel(transferRequestDto)));
    }

    @PostMapping("/add_all")
    public List<TransferResponseDto> addAll(@RequestBody List<TransferRequestDto> transferRequestDtos) {
        return transferRequestDtos.stream()
                .map(transferMapper::toModel)
                .map(transferService::add)
                .map(transferMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TransferResponseDto get(@PathVariable Long id) {
        return transferMapper.toDto(transferService.get(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transferService.delete(id);
    }
}
