package com.mediatuotantoph.nhlxstats.domain.game;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mediatuotantoph.nhlxstats.domain.Model;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

/**
 * Class for game which assembles info about the game opponents, score etc.
 * 
 * @author Pirkka Huhtala
 *
 */
@Document
public class Game extends Model {
    
    private Date date;
    private Date editTime;
    private Score score;
    private Opponent home;
    private Opponent visitor;    
    
    public Game() {
        // for mapping purposes
    }

    public Game(Date date, Opponent home, Opponent visitor, Score score) {
        this.home = home;
        this.visitor = visitor;
        this.score = score;
    }

    public Date getDate() {
        return date;
    }
    
    public Nick getPlayerHome() {
        return home.getNick();
    }
    
    public Team getTeamHome() {
        return home.getTeam();
    }
    
    public Nick getPlayerVisitor() {
        return visitor.getNick();
    }
    
    public Team getTeamVisitor() {
        return visitor.getTeam();
    }

    public Stats getStatsHome() {
        return score.getHomeStats();
    }

    public Stats getStatsVisitor() {
        return score.getVisitor();
    }

    /**
     * Operation to edit game
     * @param home New home opponent
     * @param visitor New visitor opponent
     * @param score New game score
     */
    public void edit(Opponent home, Opponent visitor, Score score) {
        this.home = home;
        this.visitor = visitor;
        this.score = score;
        this.editTime = new Date();
    }

    public Date getEditTime() {
        return editTime;
    }
    
}