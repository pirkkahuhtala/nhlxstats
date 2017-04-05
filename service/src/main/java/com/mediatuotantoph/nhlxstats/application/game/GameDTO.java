package com.mediatuotantoph.nhlxstats.application.game;

import java.util.Date;

import com.mediatuotantoph.nhlxstats.application.ModelDTO;

/**
 * Class for game data transfer object.
 * 
 * @author Pirkka Huhtala
 *
 */
public class GameDTO extends ModelDTO {

    private Date date;
    private Date editDate;
    private String playerHomeName;
    private String playerVisitorName;
    private String teamHomeId;
    private String teamVisitorId;
    private StatsDTO statsHome;
    private StatsDTO statsVisitor;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getTeamHomeId() {
        return teamHomeId;
    }

    public void setTeamHomeId(String teamHomeId) {
        this.teamHomeId = teamHomeId;
    }

    public String getTeamVisitorId() {
        return teamVisitorId;
    }

    public void setTeamVisitorId(String teamVisitorId) {
        this.teamVisitorId = teamVisitorId;
    }

    public StatsDTO getStatsHome() {
        return statsHome;
    }

    public void setStatsHome(StatsDTO statsHome) {
        this.statsHome = statsHome;
    }

    public StatsDTO getStatsVisitor() {
        return statsVisitor;
    }

    public void setStatsVisitor(StatsDTO statsVisitor) {
        this.statsVisitor = statsVisitor;
    }

    public String getPlayerHomeName() {
        return playerHomeName;
    }

    public void setPlayerHomeName(String playerHomeName) {
        this.playerHomeName = playerHomeName;
    }

    public String getPlayerVisitorName() {
        return playerVisitorName;
    }

    public void setPlayerVisitorName(String playerVisitorName) {
        this.playerVisitorName = playerVisitorName;
    }

}