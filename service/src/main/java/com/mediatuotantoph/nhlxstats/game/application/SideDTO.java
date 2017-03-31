package com.mediatuotantoph.nhlxstats.game.application;

/**
 * Class for side data transfer object
 * 
 * @author Pirkka Huhtala
 *
 */
public class SideDTO {
    private String playerId;
    private String teamId;
    private ScoreDTO scoreDTO;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public ScoreDTO getScoreDTO() {
        return scoreDTO;
    }

    public void setScoreDTO(ScoreDTO scoreDTO) {
        this.scoreDTO = scoreDTO;
    }
}