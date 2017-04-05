package com.mediatuotantoph.nhlxstats.domain.game;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.mediatuotantoph.nhlxstats.domain.player.Player;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

/**
 * Class for opponent value object
 * 
 * @author Pirkka Huhtala
 *
 */
public class Opponent {

    @DBRef
    private Team team;
    @DBRef
    private Player player;
    
    public Opponent() {
        // for mapping purposes
    }

    public Opponent(Player player, Team team) {
        this.player = player;
        this.team = team;
    }
    
    public Team getTeam() {
        return team;
    }

    public Player getPlayer() {
        return player;
    }

}