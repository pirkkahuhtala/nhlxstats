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

    public Side(Player player, Team team, Score score) {
        this.player = player;
        this.team = team;
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public Team getTeam() {
        return team;
    }

    public Score getScore() {
        return score;
    }
}