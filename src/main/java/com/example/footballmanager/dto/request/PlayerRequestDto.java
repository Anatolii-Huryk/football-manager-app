package com.example.footballmanager.dto.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PlayerRequestDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private LocalDate startCareer;
    private Long footballClubId;
}
