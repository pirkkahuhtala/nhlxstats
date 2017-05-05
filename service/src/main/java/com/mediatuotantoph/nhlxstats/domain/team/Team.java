package com.mediatuotantoph.nhlxstats.domain.team;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mediatuotantoph.nhlxstats.domain.Entity;

/**
 * Class for team information.
 * 
 * @author Pirkka Huhtala
 *
 */
@Document
public class Team extends Entity<TeamId> {

    private String name;

    public Team() {
        // For mapping purposes
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    protected TeamId wrapId(String id) {
        return new TeamId(id);
    }
}