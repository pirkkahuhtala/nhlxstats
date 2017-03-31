package com.mediatuotantoph.nhlxstats.game.application.internal;

import java.util.Collection;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.game.application.GameDTO;
import com.mediatuotantoph.nhlxstats.game.application.GameResource;
import com.mediatuotantoph.nhlxstats.game.domain.model.Game;
import com.mediatuotantoph.nhlxstats.game.domain.model.GameService;
import com.mediatuotantoph.nhlxstats.player.application.PlayerDTO;
import com.mediatuotantoph.nhlxstats.player.domain.Player;
import com.mediatuotantoph.nhlxstats.player.domain.PlayerService;

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
    private PlayerService playerService;
    @Autowired
    private GameService gameService;

    @Override
    public void add(GameDTO gameDTO) {
        gameService.add(convertToGame(gameDTO));
    }

    @Override
    public void update(GameDTO gameDTO) {
        gameService.update(convertToGame(gameDTO));
    }

    @Override
    public void delete(GameDTO gameDTO) {
        gameService.delete(convertToGame(gameDTO));
    }

    @Override
    public Collection<GameDTO> find(PlayerDTO playerDTO) {
        return gameService.find(mapToPlayer(playerDTO)).stream().map(game -> convertToGameDTO(game))
                .collect(Collectors.toList());
    }

    private Player mapToPlayer(PlayerDTO playerDTO) {
        return mapper.map(playerDTO, Player.class);
    }

    private GameDTO convertToGameDTO(Game game) {
        return mapper.map(game, GameDTO.class);
    }

    private Game convertToGame(GameDTO gameDTO) {
        Game game = mapper.map(gameDTO, Game.class);
        findAndAssignPlayers(game);
        return game;
    }

    private void findAndAssignPlayers(Game game) {
        Player homePlayer = playerService.find(game.getHomePlayerId());
        game.getHome().setPlayer(homePlayer);
        Player visitorPlayer = playerService.find(game.getVisitorPlayerId());
        game.getVisitor().setPlayer(visitorPlayer);
    }

}