package com.example.footballmanager.controller;

import com.example.footballmanager.model.FootballClub;
import com.example.footballmanager.model.Player;
import com.example.footballmanager.service.FootballClubService;
import com.example.footballmanager.service.PlayerService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjectController {
    private final PlayerService playerService;
    private final FootballClubService footballClubService;

    public InjectController(PlayerService playerService, FootballClubService footballClubService) {
        this.playerService = playerService;
        this.footballClubService = footballClubService;
    }

    @PostMapping("/inject")
    public String inject() {
        Player mbappe = new Player();
        mbappe.setFirstName("Mbappe");
        mbappe.setLastName("Kylian");
        mbappe.setBirthDay(LocalDate.of(1998, Month.DECEMBER, 20));
        mbappe.setStartCareer(LocalDate.of(2010, Month.APRIL, 10));

        Player neymar = new Player();
        neymar.setFirstName("Silva Santos");
        neymar.setLastName("Neymar");
        neymar.setBirthDay(LocalDate.of(1992, Month.FEBRUARY, 5));
        neymar.setStartCareer(LocalDate.of(2002, Month.FEBRUARY, 19));

        FootballClub psg = new FootballClub();
        psg.setName("PSG");
        psg.setCity("Paris");
        psg.setCountry("France");
        psg.setCommission(0.9);
        psg.setBalance(BigDecimal.valueOf(2000000000));
        psg.getPlayers().add(mbappe);
        psg.getPlayers().add(neymar);

        Player pupkin = new Player();
        pupkin.setFirstName("Ostap");
        pupkin.setLastName("Pupkin");
        pupkin.setBirthDay(LocalDate.of(2000, Month.FEBRUARY, 5));
        pupkin.setStartCareer(LocalDate.of(2006, Month.FEBRUARY, 15));

        Player kokos = new Player();
        kokos.setFirstName("Luis");
        kokos.setLastName("Kokos");
        kokos.setBirthDay(LocalDate.of(1997, Month.APRIL, 11));
        kokos.setStartCareer(LocalDate.of(2002, Month.FEBRUARY, 2));

        FootballClub lil = new FootballClub();
        lil.setName("Lil");
        lil.setCity("Lil");
        lil.setCountry("France");
        lil.setCommission(0.1);
        lil.setBalance(BigDecimal.valueOf(9379992));
        lil.getPlayers().add(pupkin);
        lil.getPlayers().add(kokos);

        playerService.add(neymar);
        playerService.add(mbappe);
        playerService.add(pupkin);
        playerService.add(kokos);
        footballClubService.add(psg);
        footballClubService.add(lil);

        return "Inject was completed!";
    }
}
