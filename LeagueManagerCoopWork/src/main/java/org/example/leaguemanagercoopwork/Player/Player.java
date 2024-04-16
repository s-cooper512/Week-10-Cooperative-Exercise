package org.example.leaguemanagercoopwork.Player;

import jakarta.persistence.*;
import lombok.Data;
import org.example.leaguemanagercoopwork.Team.Team;

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

