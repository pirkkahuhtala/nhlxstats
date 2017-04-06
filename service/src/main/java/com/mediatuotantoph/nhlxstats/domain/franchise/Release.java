package com.mediatuotantoph.nhlxstats.domain.franchise;

import java.util.ArrayList;
import java.util.List;

import com.mediatuotantoph.nhlxstats.domain.team.Team;

public class Release {

    private List<Team> teams = new ArrayList<>();

    public boolean contains(Team team) {
        return teams.contains(team);
    }
    
}