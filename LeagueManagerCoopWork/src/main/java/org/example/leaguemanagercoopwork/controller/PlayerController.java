package org.example.leaguemanagercoopwork.controller;

import org.example.leaguemanagercoopwork.player.Player;
import org.example.leaguemanagercoopwork.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players") // maps this to all methods in class
public class PlayerController {

    @Autowired
    PlayerService playerService;

    // ========== BASIC CRUD OPERATIONS ==============
    // create new player
    @PostMapping // already has "/players" because of the @RequestMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    // get player by ID
    @GetMapping("/{id}")
    public Player getPlayerById(Long id) throws Exception {
        return playerService.getPlayerById(id);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // update player details
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player playerDetails) throws Exception {
        return playerService.updatePlayer(id, playerDetails);
    }

    // delete player
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) throws Exception {
        playerService.deletePlayer(id);
    }
}
