package com.example.footballmanager.dto.request;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TransferRequestDto {
    private Long playerId;
    private Long footballClubId;
    private BigDecimal price;
}
