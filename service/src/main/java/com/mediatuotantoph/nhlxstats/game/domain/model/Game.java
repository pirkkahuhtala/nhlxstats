package com.mediatuotantoph.nhlxstats.game.domain.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mediatuotantoph.nhlxstats.common.Model;

/**
 * Class for game which assembles info about the game opponents, score etc.
 * 
 * @author Pirkka Huhtala
 *
 */
@Document
public class Game extends Model {
    
    private Date date;
    private Side home;
    private Side visitor;

    public Game() {
        // for mapping purposes
    }
    
    public Game(Date date, Side home, Side visitor) {
        this.date = date;
        this.home = home;
        this.visitor = visitor;
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
    
}