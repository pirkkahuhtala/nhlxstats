package com.mediatuotantoph.nhlxstats.domain.player;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Class player repository.
 * @author Pirkka Huhtala
 *
 */
public interface PlayerRepository extends MongoRepository<Player, String> {}