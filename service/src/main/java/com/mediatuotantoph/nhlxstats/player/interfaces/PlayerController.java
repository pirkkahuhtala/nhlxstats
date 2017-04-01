package com.mediatuotantoph.nhlxstats.player.interfaces;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mediatuotantoph.nhlxstats.core.RestResource;
import com.mediatuotantoph.nhlxstats.game.application.GameDTO;
import com.mediatuotantoph.nhlxstats.game.application.GameResource;
import com.mediatuotantoph.nhlxstats.player.application.PlayerDTO;
import com.mediatuotantoph.nhlxstats.player.application.PlayerResource;

/**
 * Class for players rest api
 * 
 * @author Pirkka Huhtala
 *
 */
@RestResource
@RequestMapping(value = "players")
public class PlayerController {

    @Autowired
    private PlayerResource playerResource;
    @Autowired
    private GameResource gameResource;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PlayerDTO find(@PathVariable String id) {
        return playerResource.find(id);
    }

    @RequestMapping(value = "/{playerId}/games", method = RequestMethod.GET)
    public Collection<GameDTO> findByPlayerId(@PathVariable String playerId) {
        return gameResource.findByPlayerId(playerId);
    }

}