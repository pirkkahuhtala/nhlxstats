package com.mediatuotantoph.nhlxstats.game.domain.model;

import java.util.Collection;

/**
 * Interface for game repository.
 * 
 * @author Pirkka Huhtala
 *
 */
public interface GameRepository {

    public void add(Game game);

    public void update(Game game);

    public void delete(Game game);

    public Collection<Game> find(Integer playerId);

}