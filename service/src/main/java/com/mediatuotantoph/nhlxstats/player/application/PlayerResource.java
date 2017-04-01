package com.mediatuotantoph.nhlxstats.player.application;

/**
 * Interface for player resource
 * @author Pirkka Huhtala
 *
 */
public interface PlayerResource {

    public PlayerDTO find(String id);
    
}