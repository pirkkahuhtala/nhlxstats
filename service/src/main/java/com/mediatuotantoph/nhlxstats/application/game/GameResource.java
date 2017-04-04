package com.mediatuotantoph.nhlxstats.application.game;

import java.util.Collection;

/**
 * Interface for game application service.
 * @author Pirkka Huhtala
 *
 */
public interface GameResource {

    public void add(GameDTO game);
    
    public void update(GameDTO game);
    
    public void delete(GameDTO game);
    
    public Collection<GameDTO> findByPlayerId(String playerId);
    
}