package com.mediatuotantoph.nhlxstats.application.game.internal;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.application.game.GameDTO;
import com.mediatuotantoph.nhlxstats.application.game.GameService;
import com.mediatuotantoph.nhlxstats.application.game.StatsDTO;
import com.mediatuotantoph.nhlxstats.domain.franchise.Platform;
import com.mediatuotantoph.nhlxstats.domain.game.Game;
import com.mediatuotantoph.nhlxstats.domain.game.GameFactory;
import com.mediatuotantoph.nhlxstats.domain.game.GameRepository;
import com.mediatuotantoph.nhlxstats.domain.game.OpponentFactory;
import com.mediatuotantoph.nhlxstats.domain.game.Score;
import com.mediatuotantoph.nhlxstats.domain.game.ScoreFactory;
import com.mediatuotantoph.nhlxstats.domain.game.Stats;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.player.NickId;
import com.mediatuotantoph.nhlxstats.domain.player.NickRegister;
import com.mediatuotantoph.nhlxstats.domain.team.Team;
import com.mediatuotantoph.nhlxstats.domain.team.TeamRepository;

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
    private ScoreFactory scoreFactory;
    @Autowired
    private NickRegister nickRegister;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private GameFactory gameFactory;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private OpponentFactory opponentFactory;

    @Override
    public void insert(GameDTO gameDTO) {

        Nick nickHome = nickRegister.createIfNotExists(gameDTO.getPlayerHomeName(), Platform.PS);
        Nick nickVisitor = nickRegister.createIfNotExists(gameDTO.getPlayerVisitorName(), Platform.PS);
        Team teamHome = teamRepository.findOne(gameDTO.getTeamHomeId());
        Team teamVisitor = teamRepository.findOne(gameDTO.getTeamVisitorId());
        Game game = gameFactory.create(gameDTO.getDate(), nickHome, nickVisitor, teamHome, teamVisitor,
                getStats(gameDTO));
        game = gameRepository.insert(game);

        mapper.map(convertToGameDTO(game), gameDTO);
    }

    @Override
    public void edit(GameDTO gameDTO) {
        Game game = gameRepository.findOne(gameDTO.getId());
        if (game == null) {
            // throw exception
        }
        Nick nickHome = nickRegister.createIfNotExists(gameDTO.getPlayerHomeName(), Platform.PS);
        Nick nickVisitor = nickRegister.createIfNotExists(gameDTO.getPlayerVisitorName(), Platform.PS);
        Team teamHome = teamRepository.findOne(gameDTO.getTeamHomeId());
        Team teamVisitor = teamRepository.findOne(gameDTO.getTeamVisitorId());
        game.edit(opponentFactory.create(nickHome, teamHome), opponentFactory.create(nickVisitor, teamVisitor),
                getStats(gameDTO));
        game = gameRepository.save(game);

        mapper.map(convertToGameDTO(game), gameDTO);
    }

    @Override
    public void delete(GameDTO gameDTO) {
        Game game = gameRepository.findOne(gameDTO.getId());
        if (game == null) {
            // throw exception
        }
        gameRepository.delete(game);
    }

    @Override
    public Collection<GameDTO> findByNickId(String nickId) {
        Nick nick = nickRegister.find(new NickId(nickId));
        return gameRepository.findByHomeNickId(nick.getId().value()).stream()
                .map(game -> mapper.map(game, GameDTO.class)).collect(Collectors.toList());
    }

    @Override
    public GameDTO find(String id) {
        Game game = Optional.ofNullable(gameRepository.findOne(id)).orElse(new Game());
        return mapper.map(game, GameDTO.class);
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