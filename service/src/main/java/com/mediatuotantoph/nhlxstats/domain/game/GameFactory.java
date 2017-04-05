package com.mediatuotantoph.nhlxstats.domain.game;

import java.util.Date;

import com.mediatuotantoph.nhlxstats.domain.player.Player;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

/**
 * Interface for game object factory
 * 
 * @author Pirkka Huhtala
 *
 */
public interface GameFactory {

    public Game create(Date date, Player playerHome, Player playerVisitor, Team teamHome, Team teamVisitor,
            Score score);

}