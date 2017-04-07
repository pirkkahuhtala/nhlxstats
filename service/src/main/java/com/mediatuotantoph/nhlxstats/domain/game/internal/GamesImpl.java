package com.mediatuotantoph.nhlxstats.domain.game.internal;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.domain.franchise.GameVersion;
import com.mediatuotantoph.nhlxstats.domain.franchise.Platform;
import com.mediatuotantoph.nhlxstats.domain.game.Game;
import com.mediatuotantoph.nhlxstats.domain.game.GameFactory;
import com.mediatuotantoph.nhlxstats.domain.game.GameRepository;
import com.mediatuotantoph.nhlxstats.domain.game.Games;
import com.mediatuotantoph.nhlxstats.domain.game.Score;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.player.NickRegister;
import com.mediatuotantoph.nhlxstats.domain.team.Team;
import com.mediatuotantoph.nhlxstats.domain.team.TeamRepository;

/**
 * Class for games implementation
 * 
 * @author Pirkka Huhtala
 *
 */
@Service
public class GamesImpl implements Games {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private NickRegister nickRegister;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private GameFactory gameFactory;

    @Override
    public Game insert(Date date, String playerHome, String playerVisitor, String teamHome, String teamVisitor,
            Score score, GameVersion version) {
        Nick nickHome = nickRegister.find(playerHome);
        if (nickHome == null) {
            nickHome = nickRegister.register(playerHome, Platform.PS);
        }
        Nick nickVisitor = nickRegister.find(playerVisitor);
        if (nickVisitor == null) {
            nickVisitor = nickRegister.register(playerVisitor, Platform.PS);
        }
        Team team1 = teamRepository.findOne(teamHome);
        Team team2 = teamRepository.findOne(teamVisitor);
        Game game = gameFactory.create(date, nickHome, nickVisitor, team1, team2, score);
        gameRepository.insert(game);

        return game;
    }

    @Override
    public Collection<Game> find(Nick nick) {
        return gameRepository.findByHomeNickId(nick.getId().value());
    }

}
