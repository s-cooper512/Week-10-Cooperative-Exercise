package org.example.leaguemanagercoopwork.Tournament;

import jakarta.persistence.*;
import lombok.Data;
import org.example.leaguemanagercoopwork.Team.Team;

import java.util.List;

@Entity
@Data
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<Team> teams;

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void removeTeam(Team team) {
        teams.removeIf(team1 -> team1.equals(team));
    }
}

