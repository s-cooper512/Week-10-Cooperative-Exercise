package org.example.leaguemanagercoopwork.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    IPlayerRepository playerRepository;
    // ========== BASIC CRUD OPERATIONS ==============
    // create new player
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    // get player by ID
    public Player getPlayerById(Long id) throws Exception {
        return playerRepository.findById(id)
                .orElseThrow(() -> new Exception("Player not found with id " + id));
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // update player details
    public Player updatePlayer(Long id, Player playerDetails) throws Exception {
        Player playerToUpdate = playerRepository.findById(id) // finds an existing player we want to updated
                .orElseThrow(() -> new Exception("Player not found with id " + id)); // throws exception if ID is not found

        playerToUpdate.setName(playerDetails.getName()); // updates player name to provided team name
        playerToUpdate.setTeam(playerDetails.getTeam()); // updates player team to provided team

        return playerRepository.save(playerToUpdate); // saves updated player to the database
    }

    // delete player
    public void deletePlayer(Long id) throws Exception {
        Player playerToDelete = playerRepository.findById(id) // finds player by the ID and assigns to player object
                        .orElseThrow(() -> new Exception("Player not found with ID")); // 

        playerRepository.delete(playerToDelete); // deletes player from DB
    }
}
