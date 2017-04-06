package com.mediatuotantoph.nhlxstats.domain.game;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.mediatuotantoph.nhlxstats.domain.player.Nick;
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
    private Nick nick;
    
    public Opponent() {
        // for mapping purposes
    }

    public Opponent(Nick player, Team team) {
        this.nick = player;
        this.team = team;
    }
    
    public Team getTeam() {
        return team;
    }

    public Nick getNick() {
        return nick;
    }

}