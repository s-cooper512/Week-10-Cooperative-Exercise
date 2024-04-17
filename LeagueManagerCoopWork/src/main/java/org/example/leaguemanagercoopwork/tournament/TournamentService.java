package org.example.leaguemanagercoopwork.tournament;

import org.example.leaguemanagercoopwork.team.ITeamRepository;
import org.example.leaguemanagercoopwork.player.Player;
import org.example.leaguemanagercoopwork.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TournamentService {

    @Autowired
    ITournamentRepository tournamentRepository;
    @Autowired
    ITeamRepository teamRepository;

    // ========== BASIC CRUD OPERATIONS ==============
    // get all tournaments
    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    // create new tournament
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament); // saves tournament object to DB
    }

    // get tournament by ID
    public Tournament getTournamentById(Long id) throws Exception {
        return tournamentRepository.findById(id) // return the tournament object with the ID
                .orElseThrow(() -> new Exception("Tournament not found with ID " + id)); // exception if not found
    }

    // update tournament
    public Tournament updateTournament(Long id, Tournament tournamentDetails) throws Exception {
        Tournament tournamentToUpdate = tournamentRepository.findById(id) // find tournament we want to update
                .orElseThrow(() -> new Exception("Tournament not found with ID " + id)); // throws exception if it doesn't exist

        tournamentToUpdate.setName(tournamentDetails.getName()); // update existing tournament name with provided tournament name
        tournamentToUpdate.setTeams(tournamentDetails.getTeams()); // update existing tournament teams with provided tournament teams

        return tournamentRepository.save(tournamentToUpdate); // saves the tournament we wanted to update with the new details to the DB
    }

    // delete tournament
    public void deleteTournament(Long id) throws Exception {
        Tournament tournamentToDelete = tournamentRepository.findById(id)
                .orElseThrow(() -> new Exception("Tournament not found with ID " + id)); // throws exception if it doesn't exist

        tournamentRepository.delete(tournamentToDelete); // deletes tournament from DB
    }

    // ========== ADDITIONAL FUNCTIONALITY ==============
    // add a team to a tournament
    public void addTeamToTournament(Long tournamentId, Long teamId) throws Exception {
        // find tournament to add team to
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new Exception("Unable to find tournament with ID " + tournamentId));

        // find team to add to the tournament
        Team teamToAdd = teamRepository.findById(teamId)
                .orElseThrow(() -> new Exception("Unable to find team with ID " + teamId));

        // add team to tournament
        tournament.getTeams().add(teamToAdd);

        // save tournament changes to DB
        tournamentRepository.save(tournament);
    }

    public void deleteTeamFromTournament(Long tournamentId, Long teamId) throws Exception {
        // find tournament to add team to
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new Exception("Unable to find tournament with ID " + tournamentId));

        // find team that is in the tournament that we want to remove
        Team teamToDelete = teamRepository.findById(teamId)
                .orElseThrow(() -> new Exception("Unable to find team with ID " + teamId));

        // Remove team from list of teams on the tournament
        tournament.getTeams().remove(teamToDelete);

        // Save tournament to database
        tournamentRepository.save(tournament);
    }

    // get all teams in a tournament
    public List<Team> getAllTeamsInTournament(Long id) throws Exception {
        // find tournament we want the list of teams from
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new Exception("Unable to find tournament with ID " + id));

        // return a list of teams belonging to the tournament
        return tournament.getTeams();
    }

    public List<Player> getAllPlayersInTournament(Long ID) throws Exception {
        List<Team> allTeams = getTournamentById(ID).getTeams();
        List<Player> playerList = new ArrayList<>();
        allTeams.forEach(team -> {
            playerList.addAll(team.getPlayers());
        });

        return playerList;
    }
}
