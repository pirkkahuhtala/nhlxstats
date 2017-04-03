package com.mediatuotantoph.nhlxstats.team.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mediatuotantoph.nhlxstats.team.domain.model.Team;

/**
 * Interface for team repository.
 * 
 * @author Pirkka Huhtala
 *
 */
public interface TeamRepository extends MongoRepository<Team, String> {}