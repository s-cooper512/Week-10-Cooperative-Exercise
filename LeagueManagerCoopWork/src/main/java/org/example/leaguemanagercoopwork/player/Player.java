package org.example.leaguemanagercoopwork.player;

import jakarta.persistence.*;
import lombok.Data;
import org.example.leaguemanagercoopwork.team.Team;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Team team;
}

