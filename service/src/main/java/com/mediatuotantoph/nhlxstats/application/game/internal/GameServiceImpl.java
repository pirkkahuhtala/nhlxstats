package com.mediatuotantoph.nhlxstats.application.game.internal;

import java.util.Collection;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.application.game.GameDTO;
import com.mediatuotantoph.nhlxstats.application.game.GameService;
import com.mediatuotantoph.nhlxstats.application.game.StatsDTO;
import com.mediatuotantoph.nhlxstats.domain.franchise.GameVersion;
import com.mediatuotantoph.nhlxstats.domain.game.Game;
import com.mediatuotantoph.nhlxstats.domain.game.Games;
import com.mediatuotantoph.nhlxstats.domain.game.Score;
import com.mediatuotantoph.nhlxstats.domain.game.ScoreFactory;
import com.mediatuotantoph.nhlxstats.domain.game.Stats;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.player.NickRegister;

/**
 * Class for game application service.
 * 
 * @author Pirkka Huhtala
 *
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private Mapper mapper;
    @Autowired
    private Games games;
    @Autowired
    private ScoreFactory scoreFactory;
    @Autowired
    private NickRegister nickRegister;

    @Override
    public void insert(GameDTO gameDTO) {
        Game game = games.insert(gameDTO.getDate(), gameDTO.getPlayerHomeName(), gameDTO.getPlayerVisitorName(),
                gameDTO.getTeamHomeId(), gameDTO.getTeamVisitorId(), getStats(gameDTO), new GameVersion());
        mapper.map(convertToGameDTO(game), gameDTO);
    }

    @Override
    public Collection<GameDTO> findByPlayerName(String nickname) {
        Nick nick = nickRegister.find(nickname);
        return games.find(nick).stream().map(game -> mapper.map(game, GameDTO.class)).collect(Collectors.toList());
    }

    private Score getStats(GameDTO gameDTO) {
        return scoreFactory.create(convertToStats(gameDTO.getStatsHome()), convertToStats(gameDTO.getStatsVisitor()));
    }

    private Stats convertToStats(StatsDTO statsDTO) {
        return mapper.map(statsDTO, Stats.class);
    }

    private GameDTO convertToGameDTO(Game game) {
        return mapper.map(game, GameDTO.class);
    }

}