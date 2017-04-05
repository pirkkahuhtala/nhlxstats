package com.mediatuotantoph.nhlxstats.domain.game;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

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