package com.mediatuotantoph.nhlxstats.domain.game;

import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

/**
 * Interface for Opponent factory
 * 
 * @author Pirkka Huhtala
 *
 */
public interface OpponentFactory {

    public Opponent create(Nick nick, Team platform);

}