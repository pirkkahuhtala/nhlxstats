package com.mediatuotantoph.nhlxstats.player.domain;

/**
 * Interface for player service.
 * 
 * @author Pirkka Huhtala
 *
 */
public interface PlayerService {

    public Player find(Integer playerId);

}