package com.mediatuotantoph.nhlxstats.domain.game;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.mediatuotantoph.nhlxstats.domain.player.Player;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

/**
 * Value object for side in game.
 * 
 * @author Pirkka Huhtala
 *
 */
public class Side {
    
    @DBRef
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

}