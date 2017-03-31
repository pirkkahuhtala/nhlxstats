package com.mediatuotantoph.nhlxstats.game.application;

import java.util.Date;

import com.mediatuotantoph.nhlxstats.common.ModelDTO;

/**
 * Class for game data transfer object.
 * 
 * @author Pirkka Huhtala
 *
 */
public class GameDTO extends ModelDTO {

    private Date date;
    private SideDTO home;
    private SideDTO visitor;
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SideDTO getHome() {
        if (home == null) {
            home = new SideDTO();
        }
        return home;
    }

    public void setHome(SideDTO home) {
        this.home = home;
    }

    public SideDTO getVisitor() {
        return visitor;
    }

    public void setVisitor(SideDTO visitor) {
        if (visitor == null) {
            visitor = new SideDTO();
        }
        this.visitor = visitor;
    }
}