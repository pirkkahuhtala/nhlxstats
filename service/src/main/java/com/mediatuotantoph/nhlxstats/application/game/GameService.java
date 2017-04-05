package com.mediatuotantoph.nhlxstats.application.game;

import java.util.Collection;

/**
 * Interface for game application service.
 * @author Pirkka Huhtala
 *
 */
public interface GameService {

    public void insert(GameDTO game);

    public Collection<GameDTO> findByPlayerName(String name);
    
}