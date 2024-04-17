package org.example.leaguemanagercoopwork.controller;

import org.example.leaguemanagercoopwork.player.Player;
import org.example.leaguemanagercoopwork.team.Team;
import org.example.leaguemanagercoopwork.team.TeamService;
import org.example.leaguemanagercoopwork.tournament.ITournamentRepository;
import org.example.leaguemanagercoopwork.tournament.Tournament;
import org.example.leaguemanagercoopwork.tournament.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/tournaments")
@RestController
public class TournamentController {

    @Autowired
    TournamentService tournamentService;

    // ========== BASIC CRUD OPERATIONS ==============
    // get all tournaments
    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    //create new tournament
    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentService.createTournament(tournament);
    }

    // get tournament by ID
    @GetMapping("/{id}")
    public Tournament getTournamentById(@PathVariable Long id) throws Exception {
        return tournamentService.getTournamentById(id);
    }

    // update tournament
    @PutMapping("/{id}")
    public Tournament updateTournament(@PathVariable Long id, @RequestBody Tournament tournamentDetails) throws Exception {
        return tournamentService.updateTournament(id, tournamentDetails); // id of tournament we want to update
                                                    // tournament object with details we want to update original tournament with
    }

    // delete tournament
    @DeleteMapping("/{id}")
    public void deleteTournament(@PathVariable Long id) throws Exception {
        tournamentService.deleteTournament(id);
    }

    // ========== ADDITIONAL FUNCTIONALITY ==============
    // Add a team to a tournament
    @PostMapping("/{tournamentId}/teams/{teamId}")
    public void addTeamToTournament(@PathVariable Long tournamentId, @PathVariable Long teamId) throws Exception {
        tournamentService.addTeamToTournament(tournamentId, teamId);
    }

    // delete team from tournament
    @DeleteMapping("/{tournamentId}/teams/{teamId}")
    public void deleteTeamFromTournament(@PathVariable Long tournamentId, @PathVariable Long teamId) throws Exception {
        tournamentService.deleteTeamFromTournament(tournamentId, teamId);
    }

    // get all teams in a tournament
    @GetMapping("/{id}/teams")
    public List<Team> getAllTeamsInTournament(@PathVariable Long id) throws Exception {
        return tournamentService.getAllTeamsInTournament(id);
    }

    @GetMapping("/{ID}/players")
    public List<Player> getAllPlayersInTournament(@PathVariable Long ID) throws Exception {
        return tournamentService.getAllPlayersInTournament(ID);
    }
}
