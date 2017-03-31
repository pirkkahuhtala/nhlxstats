package com.mediatuotantoph.nhlxstats.game.domain.model;

import java.util.Collection;

import com.mediatuotantoph.nhlxstats.player.domain.Player;

/**
 * Interface for game service
 * 
 * @author Pirkka Huhtala
 *
 */
public interface GameService {

    public void add(Game game);

    public Collection<Game> find(Player id);

    public void update(Game game);

    public void delete(Game game);

}
