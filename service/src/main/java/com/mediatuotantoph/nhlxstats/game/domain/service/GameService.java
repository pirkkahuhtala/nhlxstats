package com.mediatuotantoph.nhlxstats.game.domain.service;

import java.util.Collection;

import com.mediatuotantoph.nhlxstats.game.domain.model.Game;
import com.mediatuotantoph.nhlxstats.player.domain.model.Player;

/**
 * Interface for game service
 * 
 * @author Pirkka Huhtala
 *
 */
public interface GameService {

    /**
     * Adds new game
     * @param game Game to be added
     * @throws NHLXStatsException if invalid game
     */
    public void add(Game game);

    /**
     * Updates existings game
     * @param game Game to be updated
     * @throws NHLXStatsException if invalid game
     */
    public void update(Game game);

    /**
     * Deletes existing game
     * @param game Game to be deleted
     */
    public void delete(Game game);
    
    /**
     * Finds player's 5 last games
     * @param player Player which games should be found
     * @return List of player's games
     */
    public Collection<Game> find(Player player);

}
