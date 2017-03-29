package com.mediatuotantoph.nhlxstats.game.domain;

import java.util.Date;

/**
 * Class for Game which contains info about the game score.
 * 
 * @author Pirkka Huhtala
 *
 */
public class Game {
	private Integer id;
	private Date date;
	
	public Integer getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
}