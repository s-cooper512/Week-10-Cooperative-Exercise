package org.example.leaguemanagercoopwork.tournament;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.example.leaguemanagercoopwork.team.Team;

import java.util.ArrayList;
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
}

