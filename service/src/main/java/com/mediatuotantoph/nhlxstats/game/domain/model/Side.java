package com.mediatuotantoph.nhlxstats.game.domain.model;

import com.mediatuotantoph.nhlxstats.player.domain.Player;
import com.mediatuotantoph.nhlxstats.team.domain.Team;

/**
 * Value object for side in game.
 * 
 * @author Pirkka Huhtala
 *
 */
public class Side {
    private Player player;
    private Team team;
    private Score score;

    public Side() {
        // for mapping purposes
    }

    public Side(Player player, Team team, Score score) {
        this.player = player;
        this.team = team;
        this.score = score;
    }

    public Player getPlayer() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        if (team == null) {
            team = new Team();
        }
        return team;
    }

    public Score getScore() {
        return score;
    }

    public Integer getPlayerId() {
        return getPlayer().getId();
    }
}