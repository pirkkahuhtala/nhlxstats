package com.mediatuotantoph.nhlxstats.game.domain.repository;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mediatuotantoph.nhlxstats.game.domain.model.Game;

/**
 * Interface for game repository.
 * 
 * @author Pirkka Huhtala
 *
 */
@Repository
public interface GameRepository extends MongoRepository<Game, String> {

    public Collection<Game> findByHomePlayerId(String playerId);

}