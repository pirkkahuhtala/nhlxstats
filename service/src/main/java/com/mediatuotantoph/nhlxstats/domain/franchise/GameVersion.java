package com.mediatuotantoph.nhlxstats.domain.franchise;

import com.mediatuotantoph.nhlxstats.domain.Model;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

public class GameVersion extends Model {

    private Platform platform;
    private Release release;
    
    public Platform getPlatform() {
        return platform;
    }
    
    public boolean isTeamAllowed(Team team) {
        return release.contains(team);
    }
    
}