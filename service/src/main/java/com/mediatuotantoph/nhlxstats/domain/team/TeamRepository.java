package com.mediatuotantoph.nhlxstats.domain.team;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface for team repository.
 * 
 * @author Pirkka Huhtala
 *
 */
public interface TeamRepository extends MongoRepository<Team, String> {}