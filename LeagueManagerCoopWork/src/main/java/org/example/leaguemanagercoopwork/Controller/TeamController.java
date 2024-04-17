package org.example.leaguemanagercoopwork.controller;

import org.example.leaguemanagercoopwork.player.Player;
import org.example.leaguemanagercoopwork.player.PlayerService;
import org.example.leaguemanagercoopwork.team.Team;
import org.example.leaguemanagercoopwork.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{ID}")
    public Optional<Team> getOneTeamByID (@PathVariable long ID) {
        return teamService.getTeamById(ID);
    }

    @DeleteMapping("/{ID}")
    public void deleteTeamByID (@PathVariable long ID) {
        teamService.deleteTeam(ID);
    }

    @PutMapping("/{ID}")
    public String updateTeamByID (@PathVariable long ID, @RequestBody Team updatedTeam) {
        return teamService.updateTeam(ID, updatedTeam);
    }

    @PostMapping
    public String addNewTeam (@RequestBody Team newTeam) {
        teamService.saveTeam(newTeam);
        return "Team added successfully!";
    }

    @PutMapping("/{teamID}/{playerID}")
    public String addPlayerToTeam (@PathVariable long teamID, @PathVariable long playerID) throws Exception {
        return teamService.addPlayerToTeam(teamID, playerID);
    }

    @DeleteMapping("/{teamID}/{playerID}")
    public String removePlayerFromTeam (@PathVariable long teamID, @PathVariable long playerID) throws Exception {
        return teamService.removePlayerFromTeam(teamID, playerID);
    }
}
