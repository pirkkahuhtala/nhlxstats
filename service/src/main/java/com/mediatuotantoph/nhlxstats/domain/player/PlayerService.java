package com.mediatuotantoph.nhlxstats.domain.player;

/**
 * Interface for player service.
 * 
 * @author Pirkka Huhtala
 *
 */
public interface PlayerService {

    public Player find(String playerId);

}