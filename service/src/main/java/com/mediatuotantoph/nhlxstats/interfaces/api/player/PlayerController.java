package com.mediatuotantoph.nhlxstats.interfaces.api.player;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mediatuotantoph.nhlxstats.application.game.GameDTO;
import com.mediatuotantoph.nhlxstats.application.game.GameService;
import com.mediatuotantoph.nhlxstats.application.player.PlayerDTO;
import com.mediatuotantoph.nhlxstats.application.player.PlayerService;
import com.mediatuotantoph.nhlxstats.interfaces.api.RestResource;

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
    private PlayerService playerResource;
    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PlayerDTO find(@PathVariable String id) {
        return playerResource.find(id);
    }

    @RequestMapping(value = "/{name}/games", method = RequestMethod.GET)
    public Collection<GameDTO> findByPlayerId(@PathVariable String name) {
        return gameService.findByPlayerName(name);
    }

}