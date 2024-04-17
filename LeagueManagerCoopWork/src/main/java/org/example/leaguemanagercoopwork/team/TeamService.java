package org.example.leaguemanagercoopwork.team;

import org.example.leaguemanagercoopwork.player.Player;
import org.example.leaguemanagercoopwork.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerService playerService;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    public String updateTeam (Long id, Team team) {
        Optional<Team> oldTeam = getTeamById(id);
        if (oldTeam.isPresent()) {
            Team destinationTeam = oldTeam.get();
            destinationTeam.setId(team.getId());
            destinationTeam.setName(team.getName());
            destinationTeam.setPlayers(team.getPlayers());

            teamRepository.save(destinationTeam);
            return "Team updated successfully!";
        }
        return "Team failed to update...";
    }

    public String addPlayerToTeam (Long teamID, Long playerID) throws Exception {
        Optional<Team> thisTeam = getTeamById(teamID);
        Team tempTeam = thisTeam.get();
        Player thisPlayer = playerService.getPlayerById(playerID);

        thisPlayer.setTeam(tempTeam);
        playerService.createPlayer(thisPlayer);

        return thisPlayer.getName() + " moved to " + tempTeam.getName();
    }

    public String removePlayerFromTeam (Long teamID, Long playerID) throws Exception {
        Optional<Team> thisTeam = getTeamById(teamID);
        Team tempTeam = thisTeam.get();
        Player thisPlayer = playerService.getPlayerById(playerID);

        thisPlayer.setTeam(null);
        playerService.createPlayer(thisPlayer);

        return thisPlayer.getName() + " removed from " + tempTeam.getName();
    }
}
