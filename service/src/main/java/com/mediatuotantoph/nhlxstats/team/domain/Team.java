package com.mediatuotantoph.nhlxstats.team.domain;

/**
 * Class for team information.
 * 
 * @author Pirkka Huhtala
 *
 */
public class Team {
    private Integer id;
    private String name;
    
    public Team() {
        // For mapping purposes
    }

    public Team(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}