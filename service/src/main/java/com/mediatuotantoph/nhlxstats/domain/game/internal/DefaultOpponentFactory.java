package com.mediatuotantoph.nhlxstats.domain.game.internal;

import org.springframework.stereotype.Component;

import com.mediatuotantoph.nhlxstats.domain.game.Opponent;
import com.mediatuotantoph.nhlxstats.domain.game.OpponentFactory;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

@Component
public class DefaultOpponentFactory implements OpponentFactory {

    @Override
    public Opponent create(Nick nick, Team team) {
        return new Opponent(nick, team);
    }

}
