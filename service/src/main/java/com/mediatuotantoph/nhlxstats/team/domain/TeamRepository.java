package com.mediatuotantoph.nhlxstats.team.domain;

/**
 * Interface for team repository.
 * 
 * @author Pirkka Huhtala
 *
 */
public interface TeamRepository {
    
    public Team find(int teamId);

}