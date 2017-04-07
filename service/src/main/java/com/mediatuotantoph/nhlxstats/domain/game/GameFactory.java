package com.mediatuotantoph.nhlxstats.domain.game;

import java.util.Date;

import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

/**
 * Interface for game object factory
 * 
 * @author Pirkka Huhtala
 *
 */
public interface GameFactory {

    public Game create(Date date, Nick playerHome, Nick playerVisitor, Team teamHome, Team teamVisitor, Score score);

}