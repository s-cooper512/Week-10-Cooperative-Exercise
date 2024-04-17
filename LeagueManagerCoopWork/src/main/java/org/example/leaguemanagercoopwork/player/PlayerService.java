package org.example.leaguemanagercoopwork.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    IPlayerRepository playerRepository;

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player getPlayerById(Long id) throws Exception {
        return playerRepository.findById(id)
                .orElseThrow(() -> new Exception("Player not found with id " + id));
    }

    public Player updatePlayer(Long id, Player player) throws Exception {
        Player existingPlayer = playerRepository.findById(id) // finds an existing player with the desired ID
                .orElseThrow(() -> new Exception("Player not found with id " + id)); // throws exception if ID is not found

        existingPlayer.setName(player.getName()); // sets the name to whatever was provided by the player object
        existingPlayer.setTeam(player.getTeam()); // sets the team to whatever was provided by the player object

        return playerRepository.save(player); // saves to the database
    }

    public void deletePlayer(Long id) throws Exception {
        Player player = playerRepository.findById(id) // finds player by the ID and assigns to player object
                        .orElseThrow(() -> new Exception("Player not found with ID")); // 

        playerRepository.delete(player);
    }
}
