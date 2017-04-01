package com.mediatuotantoph.nhlxstats.team.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mediatuotantoph.nhlxstats.common.domain.Model;

/**
 * Class for team information.
 * 
 * @author Pirkka Huhtala
 *
 */
@Document
public class Team extends Model {
    
    private String name;
    
    public Team() {
        // For mapping purposes
    }
    
    public Team(String name) {
        this(null, name);
    }

    public Team(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}