package com.mediatuotantoph.nhlxstats.domain.game;

import java.util.Date;

import com.mediatuotantoph.nhlxstats.domain.franchise.GameVersion;

/**
 * Interfaces for inserting game stats domain service
 * 
 * @author Pirkka Huhtala
 *
 */
public interface Games {

    /**
     * Allows to insert game stat
     * 
     * @param date
     *            Date game was played
     * @param playerHome
     *            Username of the home player
     * @param playerVisitor
     *            Username of the visitor player
     * @param teamHome
     *            Id of the home team
     * @param teamVisitor
     *            Id of the visitor team
     * @param score
     *            Game score
     */
    public Game insert(Date date, String playerHome, String playerVisitor, String teamHome, String teamVisitor,
            Score score, GameVersion release);

}