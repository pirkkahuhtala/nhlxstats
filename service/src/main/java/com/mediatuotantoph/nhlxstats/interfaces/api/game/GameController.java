package com.mediatuotantoph.nhlxstats.interfaces.api.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mediatuotantoph.nhlxstats.application.game.GameDTO;
import com.mediatuotantoph.nhlxstats.application.game.GameService;
import com.mediatuotantoph.nhlxstats.interfaces.api.RestResource;

/**
 * Rest API for games
 * 
 * @author Pirkka Huhtala
 *
 */
@RestResource
@RequestMapping(value = "games")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.POST)
    public GameDTO add(GameDTO game) {
        gameService.insert(game);
        return game;
    }

}