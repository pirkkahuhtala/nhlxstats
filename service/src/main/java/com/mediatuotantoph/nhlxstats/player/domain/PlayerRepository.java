package com.mediatuotantoph.nhlxstats.player.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Class player repository.
 * @author Pirkka Huhtala
 *
 */
public interface PlayerRepository extends MongoRepository<Player, String> {}