package com.mediatuotantoph.nhlxstats.application.player;

/**
 * Interface for player resource
 * @author Pirkka Huhtala
 *
 */
public interface PlayerResource {

    public PlayerDTO find(String id);
    
}