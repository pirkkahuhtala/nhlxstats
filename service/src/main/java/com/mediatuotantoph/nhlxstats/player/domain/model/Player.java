package com.mediatuotantoph.nhlxstats.player.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mediatuotantoph.nhlxstats.common.Model;

/**
 * Class for player which contain information about player profile.
 * 
 * @author Pirkka Huhtala
 *
 */
@Document
public class Player extends Model {
    
    private String name;

    public Player() {
        // for mapping purposes
    }
    
    public Player(String name) {
        this(null, name);
    }

    public Player(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
