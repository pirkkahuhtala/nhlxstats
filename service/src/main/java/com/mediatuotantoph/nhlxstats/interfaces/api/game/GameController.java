package com.mediatuotantoph.nhlxstats.interfaces.api.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public GameDTO add(@RequestBody GameDTO game) {
        gameService.insert(game);
        return game;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public GameDTO edit(@RequestBody GameDTO game) {
        gameService.edit(game);
        return game;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        gameService.delete(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public GameDTO find(@PathVariable String id) {
        return gameService.find(id);
    }

}