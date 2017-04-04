package com.mediatuotantoph.nhlxstats.interfaces.api.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mediatuotantoph.nhlxstats.application.game.GameDTO;
import com.mediatuotantoph.nhlxstats.application.game.GameResource;
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
    private GameResource gameResource;

    @RequestMapping(method = RequestMethod.POST)
    public GameDTO add(GameDTO game) {
        gameResource.add(game);
        return game;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public GameDTO update(GameDTO game) {
        gameResource.update(game);
        return game;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(GameDTO game) {
        gameResource.delete(game);
    }

}