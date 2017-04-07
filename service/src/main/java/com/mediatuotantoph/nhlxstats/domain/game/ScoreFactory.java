package com.mediatuotantoph.nhlxstats.domain.game;

/**
 * Inteface for score factory
 * 
 * @author Pirkka Huhtala
 *
 */
public interface ScoreFactory {

    public Score create(Stats home, Stats visitor);

}