package com.example.footballmanager.dto.response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PlayerResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private LocalDate startCareer;
    private Long footballClubId;
}
