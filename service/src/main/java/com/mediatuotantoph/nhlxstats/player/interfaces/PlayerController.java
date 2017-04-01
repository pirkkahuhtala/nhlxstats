package com.mediatuotantoph.nhlxstats.player.interfaces;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediatuotantoph.nhlxstats.game.application.GameDTO;
import com.mediatuotantoph.nhlxstats.game.application.GameResource;

/**
 * Class for players rest api
 * 
 * @author Pirkka Huhtala
 *
 */
@RestController
@RequestMapping(value = "players", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    @Autowired
    private GameResource gameResource;

    @RequestMapping("/{playerId}/games")
    public Collection<GameDTO> findByPlayerId(@PathVariable String playerId) {
        return gameResource.findByPlayerId(playerId);
    }

}