package com.mediatuotantoph.nhlxstats.player.domain;

/**
 * Class for player which contain information about player profile.
 * 
 * @author Pirkka Huhtala
 *
 */
public class Player {
    private Integer id;
    private String name;

    public Player() {
        // for mapping purposes
    }

    public Player(Integer id, String name) {
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
