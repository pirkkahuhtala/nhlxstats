package com.mediatuotantoph.nhlxstats.game.interfaces;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mediatuotantoph.nhlxstats.game.application.GameDTO;
import com.mediatuotantoph.nhlxstats.game.application.GameResource;

/**
 * Rest API for games
 * 
 * @author Pirkka Huhtala
 *
 */
@RestController
public class GameController {

    @Autowired
    private GameResource gameResource;

    @RequestMapping("/games")
    public Collection<GameDTO> findAll() {
        return Collections.emptyList();
    }

    @RequestMapping(value = "/games/{player}", method = RequestMethod.GET)
    public Collection<GameDTO> findByPlayerId(@PathVariable("player") String playerId) {
        return gameResource.findByPlayerId(playerId);
    }

}