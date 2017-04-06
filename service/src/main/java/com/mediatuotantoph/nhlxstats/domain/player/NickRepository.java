package com.mediatuotantoph.nhlxstats.domain.player;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface for player repository.
 * 
 * @author Pirkka Huhtala
 *
 */
public interface NickRepository extends MongoRepository<Nick, String> {

    public Nick findByName(String name);

}