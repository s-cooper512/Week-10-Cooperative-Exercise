package org.example.leaguemanagercoopwork.team;

import jakarta.persistence.*;
import lombok.Data;
import org.example.leaguemanagercoopwork.player.Player;

import java.util.List;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Player> players;
}

