package com.mediatuotantoph.nhlxstats.domain.game;

/**
 * Class for game score value object.
 * 
 * @author Pirkka Huhtala
 *
 */
public class Score {

    private Stats home;
    private Stats visitor;
    
    public Score() {
        // for mapping purposes
    }

    public Score(Stats stats, Stats stats2) {
        this.home = stats;
        this.visitor = stats2;
    }

    public Stats getHomeStats() {
       return home;
    }
    
    public Stats getVisitor() {
        return visitor;
    }
}