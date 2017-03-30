package com.mediatuotantoph.nhlxstats.game.application;

import java.util.Collection;

import com.mediatuotantoph.nhlxstats.player.application.PlayerDTO;

/**
 * Interface for game application service.
 * @author Pirkka Huhtala
 *
 */
public interface GameService {

    public void add(GameDTO game);
    
    public void update(GameDTO game);
    
    public void delete(GameDTO game);
    
    public Collection<GameDTO> find(PlayerDTO player);
    
}