package com.mediatuotantoph.nhlxstats.application.game.internal;

import java.util.Collection;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.application.game.GameDTO;
import com.mediatuotantoph.nhlxstats.application.game.GameResource;
import com.mediatuotantoph.nhlxstats.domain.game.Game;
import com.mediatuotantoph.nhlxstats.domain.game.GameService;
import com.mediatuotantoph.nhlxstats.domain.player.Player;
import com.mediatuotantoph.nhlxstats.domain.player.PlayerService;

/**
 * Class for game application service.
 * 
 * @author Pirkka Huhtala
 *
 */
@Service
public class DefaultGameResource implements GameResource {

    @Autowired
    private Mapper mapper;
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerService playerService;

    @Override
    public void add(GameDTO gameDTO) {
        Game game = convertToGame(gameDTO);
        gameService.add(game);
        mapper.map(convertToGameDTO(game), gameDTO);
    }

    @Override
    public void update(GameDTO gameDTO) {
        Game game = convertToGame(gameDTO);
        gameService.update(game);
        mapper.map(convertToGameDTO(game), gameDTO);
    }

    @Override
    public void delete(GameDTO gameDTO) {
        Game game = convertToGame(gameDTO);
        gameService.delete(game);
    }

    @Override
    public Collection<GameDTO> findByPlayerId(String playerId) {
        return gameService.find(playerService.find(playerId)).stream().map(game -> convertToGameDTO(game))
                .collect(Collectors.toList());
    }

    private void findAndAssignPlayers(Game game) {
        Player homePlayer = playerService.find(game.getHome().getPlayer().getId());
        game.getHome().setPlayer(homePlayer);
        Player visitorPlayer = playerService.find(game.getVisitor().getPlayer().getId());
        game.getVisitor().setPlayer(visitorPlayer);
    }

    private Game convertToGame(GameDTO gameDTO) {
        Game game = mapper.map(gameDTO, Game.class);
        findAndAssignPlayers(game);
        return game;
    }

    private GameDTO convertToGameDTO(Game game) {
        return mapper.map(game, GameDTO.class);
    }

}