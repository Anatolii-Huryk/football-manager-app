package com.example.footballmanager.model;

import lombok.Data;
import java.math.BigDecimal;
import javax.persistence.*;

@Data
@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "football_club_id")
    private FootballClub footballClub;
    private BigDecimal price;
}
