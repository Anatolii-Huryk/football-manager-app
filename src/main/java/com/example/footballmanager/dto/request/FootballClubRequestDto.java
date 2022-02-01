package com.example.footballmanager.dto.request;

import lombok.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class FootballClubRequestDto {
    private String name;
    private String country;
    private String city;
    private Double commission;
    private BigDecimal balance;
    private List<Long> playersId = new ArrayList<>();
}
