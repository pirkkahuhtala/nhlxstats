package com.mediatuotantoph.nhlxstats.player.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mediatuotantoph.nhlxstats.player.domain.model.Player;

/**
 * Class player repository.
 * @author Pirkka Huhtala
 *
 */
public interface PlayerRepository extends MongoRepository<Player, String> {}