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
    private ScoreDTO scoreDTO;

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

    public ScoreDTO getScoreDTO() {
        return scoreDTO;
    }

    public void setScoreDTO(ScoreDTO scoreDTO) {
        this.scoreDTO = scoreDTO;
    }
}