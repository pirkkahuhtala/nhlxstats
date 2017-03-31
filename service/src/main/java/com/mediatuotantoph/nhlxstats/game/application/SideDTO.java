package com.mediatuotantoph.nhlxstats.game.application;

/**
 * Class for side data transfer object
 * 
 * @author Pirkka Huhtala
 *
 */
public class SideDTO {
    private Integer playerId;
    private Integer teamId;
    private SideDTO home;
    private SideDTO visitor;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public SideDTO getHome() {
        return home;
    }

    public void setHome(SideDTO home) {
        this.home = home;
    }

    public SideDTO getVisitor() {
        return visitor;
    }

    public void setVisitor(SideDTO visitor) {
        this.visitor = visitor;
    }
}