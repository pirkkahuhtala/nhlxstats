package com.mediatuotantoph.nhlxstats.application.player;

/**
 * Interface for player resource
 * 
 * @author Pirkka Huhtala
 *
 */
public interface PlayerService {

    public PlayerDTO find(String id);

}