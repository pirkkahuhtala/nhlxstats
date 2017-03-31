package com.mediatuotantoph.nhlxstats.game.domain.service.internal;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.mediatuotantoph.nhlxstats.common.NHLXStatsException;
import com.mediatuotantoph.nhlxstats.game.domain.model.Game;
import com.mediatuotantoph.nhlxstats.game.domain.model.GameRepository;
import com.mediatuotantoph.nhlxstats.game.domain.service.GameService;
import com.mediatuotantoph.nhlxstats.player.domain.Player;

/**
 * Class for game service implementation.
 * 
 * @author Pirkka Huhtala
 *
 */
public class DefaultGameService implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public void add(Game game) {
        validate(game);
        gameRepository.insert(game);
    }

    @Override
    public void update(Game game) {
        validate(game);
        gameRepository.save(game);
    }

    @Override
    public void delete(Game game) {
        gameRepository.delete(game);
    }

    @Override
    public Collection<Game> find(Player player) {
        return gameRepository.findByHomePlayerId(player.getId());
    }

    private void validate(Game game) {
        if (game.getHome().getPlayer() == null) {
            throw new NHLXStatsException("Define home team player");
        }
        if (game.getVisitor().getPlayer() == null) {
            throw new NHLXStatsException("Define visitor team player");
        }
        if (game.getHome().getTeam().getId() == null) {
            throw new NHLXStatsException("Define home team");
        }
        if (game.getVisitor().getTeam().getId() == null) {
            throw new NHLXStatsException("Define visitor team");
        }
    }

}
