package com.mediatuotantoph.nhlxstats.game.domain.model;

/**
 * Value object class for game score.
 * @author Pirkka Huhtala
 *
 */
public class Score {
    private int goals;
    private int shots;
    private int hits;
    private int timeOnAttack;
    private int passingPercent;
    private int penaltyMins;
    private int powerplays;
    private int powerplayMins;
    private int faceoffsWon;
    private int breakaways;
    private int shorthandedGoals;
    
    public Score() {
        // For mapping purposes
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getTimeOnAttack() {
        return timeOnAttack;
    }

    public void setTimeOnAttack(int timeOnAttack) {
        this.timeOnAttack = timeOnAttack;
    }

    public int getPassingPercent() {
        return passingPercent;
    }

    public void setPassingPercent(int passingPercent) {
        this.passingPercent = passingPercent;
    }

    public int getPenaltyMins() {
        return penaltyMins;
    }

    public void setPenaltyMins(int penaltyMins) {
        this.penaltyMins = penaltyMins;
    }

    public int getPowerplays() {
        return powerplays;
    }

    public void setPowerplays(int powerplays) {
        this.powerplays = powerplays;
    }

    public int getPowerplayMins() {
        return powerplayMins;
    }

    public void setPowerplayMins(int powerplayMins) {
        this.powerplayMins = powerplayMins;
    }

    public int getFaceoffsWon() {
        return faceoffsWon;
    }

    public void setFaceoffsWon(int faceoffsWon) {
        this.faceoffsWon = faceoffsWon;
    }

    public int getBreakaways() {
        return breakaways;
    }

    public void setBreakaways(int breakaways) {
        this.breakaways = breakaways;
    }

    public int getShorthandedGoals() {
        return shorthandedGoals;
    }

    public void setShorthandedGoals(int shorthandedGoals) {
        this.shorthandedGoals = shorthandedGoals;
    }
}