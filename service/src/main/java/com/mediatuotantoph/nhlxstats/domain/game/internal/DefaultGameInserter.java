package com.mediatuotantoph.nhlxstats.domain.game.internal;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.domain.game.Game;
import com.mediatuotantoph.nhlxstats.domain.game.GameFactory;
import com.mediatuotantoph.nhlxstats.domain.game.GameInserter;
import com.mediatuotantoph.nhlxstats.domain.game.GameRepository;
import com.mediatuotantoph.nhlxstats.domain.game.Score;
import com.mediatuotantoph.nhlxstats.domain.player.Player;
import com.mediatuotantoph.nhlxstats.domain.player.PlayerRepository;
import com.mediatuotantoph.nhlxstats.domain.team.Team;
import com.mediatuotantoph.nhlxstats.domain.team.TeamRepository;

/**
 * Class for game inserter implementation
 * 
 * @author Pirkka Huhtala
 *
 */
@Service
public class DefaultGameInserter implements GameInserter {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private GameFactory gameFactory;

    @Override
    public Game insert(Date date, String playerHome, String playerVisitor, String teamHome, String teamVisitor,
            Score score) {
        
        Player player1 = playerRepository.findByName(playerHome);
        if (player1 == null) {
            player1 = new Player(playerHome);
            playerRepository.insert(player1);
        }
        Player player2 = playerRepository.findByName(playerVisitor);
        if (player2 == null) {
            player2 = new Player(playerVisitor);
            playerRepository.insert(player2);
        }
        Team team1 = teamRepository.findOne(teamHome);
        Team team2 = teamRepository.findOne(teamVisitor);
        Game game = gameFactory.create(date, player1, player2, team1, team2, score);
        gameRepository.insert(game);

        return game;
    }

}
