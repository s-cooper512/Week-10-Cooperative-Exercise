package org.example.leaguemanagercoopwork.controller;

import org.example.leaguemanagercoopwork.team.Team;
import org.example.leaguemanagercoopwork.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return teams;
    }
}
