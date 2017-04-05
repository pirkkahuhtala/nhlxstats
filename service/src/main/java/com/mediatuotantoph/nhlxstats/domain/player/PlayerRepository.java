package com.mediatuotantoph.nhlxstats.domain.player;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface for player repository.
 * 
 * @author Pirkka Huhtala
 *
 */
public interface PlayerRepository extends MongoRepository<Player, String> {

    public Player findByName(String playerHome);

}