package org.example.leaguemanagercoopwork.controller;

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
        Optional<Team> oldTeam = teamService.getTeamById(ID);
        if (oldTeam.isPresent()) {
            Team destinationTeam = oldTeam.get();
            destinationTeam.setId(updatedTeam.getId());
            destinationTeam.setName(updatedTeam.getName());
            destinationTeam.setPlayers(updatedTeam.getPlayers());
            return "Team updated successfully!";
        }

        return "Team failed to update or was not found...";
    }

    @PostMapping
    public String addNewTeam (@RequestBody Team newTeam) {
        teamService.saveTeam(newTeam);
        return "Team added successfully!";
    }
}
