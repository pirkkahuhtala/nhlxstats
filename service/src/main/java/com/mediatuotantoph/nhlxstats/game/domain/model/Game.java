package com.mediatuotantoph.nhlxstats.game.domain.model;

import java.util.Date;

/**
 * Class for game which assembles info about the game opponents, score etc.
 * 
 * @author Pirkka Huhtala
 *
 */
public class Game {
    private Integer id;
    private Date date;
    private Side home;
    private Side visitor;

    public Game() {
        // for mapping purposes
    }
    
    public Game(Integer id, Date date, Side home, Side visitor) {
        this.id = id;
        this.date = date;
        this.home = home;
        this.visitor = visitor;
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Side getHome() {
        if (home == null) {
            home = new Side();
        }
        return home;
    }

    public Side getVisitor() {
        if (visitor == null) {
            visitor = new Side();
        }
        return visitor;
    }

    public Integer getHomePlayerId() {
        return getHome().getPlayerId();
    }

    public Integer getVisitorPlayerId() {
        return getVisitor().getPlayerId();
    }
}