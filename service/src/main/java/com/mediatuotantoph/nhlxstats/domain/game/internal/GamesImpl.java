package com.mediatuotantoph.nhlxstats.domain.game.internal;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.domain.franchise.GameVersion;
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
        Nick player1 = nickRegister.find(playerHome);
        if (player1 == null) {
            nickRegister.register(playerHome, version.getPlatform());
        }
        Nick player2 = nickRegister.find(playerVisitor);
        if (player2 == null) {
            nickRegister.register(playerVisitor, version.getPlatform());
        }
        if (!player1.playsWithSamePlatform(player2)) {
            // TODO: Throw exception
        }
        Team team1 = teamRepository.findOne(teamHome);
        if (!version.isTeamAllowed(team1)) {
            // TODO: Throw exception
        }
        Team team2 = teamRepository.findOne(teamVisitor);
        if (!version.isTeamAllowed(team2)) {
            // TODO: Throw exception
        }
        Game game = gameFactory.create(date, player1, player2, team1, team2, score);
        gameRepository.insert(game);

        return game;
    }

}
