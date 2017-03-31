package com.mediatuotantoph.nhlxstats.player.domain.service;

import com.mediatuotantoph.nhlxstats.player.domain.model.Player;

/**
 * Interface for player service.
 * 
 * @author Pirkka Huhtala
 *
 */
public interface PlayerService {

    public Player find(String playerId);

}