package com.mediatuotantoph.nhlxstats.domain.game.internal;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.mediatuotantoph.nhlxstats.domain.game.Game;
import com.mediatuotantoph.nhlxstats.domain.game.GameFactory;
import com.mediatuotantoph.nhlxstats.domain.game.Opponent;
import com.mediatuotantoph.nhlxstats.domain.game.Score;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

/**
 * Class for game factory implementation.
 * 
 * @author Pirkka Huhtala
 *
 */
@Component
public class DefaultGameFactory implements GameFactory {

    @Override
    public Game create(Date date, Nick playerHome, Nick playerVisitor, Team teamHome, Team teamVisitor, Score score) {
        return new Game(date, new Opponent(playerHome, teamHome), new Opponent(playerVisitor, teamVisitor), score);
    }

}