package com.example.footballmanager.dto.response;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TransferResponseDto {
    private Long id;
    private Long playerId;
    private Long footballClubId;
    private BigDecimal price;
}
