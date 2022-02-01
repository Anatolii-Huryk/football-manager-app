package com.example.footballmanager.dto.response;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class FootballClubResponseDto {
    private Long id;
    private String name;
    private String country;
    private String city;
    private Double commission;
    private BigDecimal balance;
    private List<Long> playersId;
}
