package com.mediatuotantoph.nhlxstats.domain.game;

import java.util.Collection;
import java.util.Date;

import com.mediatuotantoph.nhlxstats.domain.franchise.GameVersion;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;

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
     * @param playerHomeId
     *            Username of the home player
     * @param playerVisitorId
     *            Username of the visitor player
     * @param teamHomeId
     *            Id of the home team
     * @param teamVisitorId
     *            Id of the visitor team
     * @param score
     *            Game score
     */
    public Game insert(Date date, String playerHomeId, String playerVisitorId, String teamHomeId, String teamVisitorId,
            Score score, GameVersion release);

    /**
     * Search five last games by nick
     * 
     * @param nick
     *            Nick which games should be found
     * @return Collection of last five games
     */
    public Collection<Game> find(Nick nick);

}