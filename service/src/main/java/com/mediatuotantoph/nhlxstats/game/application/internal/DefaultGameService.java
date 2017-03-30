package com.mediatuotantoph.nhlxstats.game.application.internal;

import java.util.Collection;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.game.application.GameDTO;
import com.mediatuotantoph.nhlxstats.game.application.GameService;
import com.mediatuotantoph.nhlxstats.game.domain.model.Game;
import com.mediatuotantoph.nhlxstats.game.domain.model.GameRepository;
import com.mediatuotantoph.nhlxstats.player.application.PlayerDTO;

/**
 * Class for game application service.
 * 
 * @author Pirkka Huhtala
 *
 */
@Service
public class DefaultGameService implements GameService {

    @Autowired
    private Mapper mapper;
    @Autowired
    private GameRepository gameRepository;
    
    @Override
    public void add(GameDTO game) {        
        gameRepository.add(convertToGame(game));
    }

    @Override
    public void update(GameDTO game) {
        gameRepository.update(convertToGame(game));
    }

    @Override
    public void delete(GameDTO game) {
        gameRepository.delete(convertToGame(game));
    }

    @Override
    public Collection<Game> find(PlayerDTO player) {
       return gameRepository.find(player.getId());
    }
    
    private Game convertToGame(GameDTO gameDTO) {
        return mapper.map(gameDTO, Game.class);
    }

}