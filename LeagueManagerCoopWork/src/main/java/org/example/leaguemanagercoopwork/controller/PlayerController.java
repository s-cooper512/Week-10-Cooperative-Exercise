package org.example.leaguemanagercoopwork.controller;

import org.example.leaguemanagercoopwork.player.Player;
import org.example.leaguemanagercoopwork.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players") // maps this to all methods in class
public class PlayerController {

    @Autowired
    PlayerService playerService;

    // create a new player
    @PostMapping // already has "/players" because of the @RequestMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    // get a player by ID
    @GetMapping("/{id}")
    public Player getPlayerById(Long id) throws Exception {
        return playerService.getPlayerById(id);
    }

    // update a player's details
    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player player) throws Exception {
        return playerService.updatePlayer(id, player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) throws Exception {
        playerService.deletePlayer(id);
    }
}
