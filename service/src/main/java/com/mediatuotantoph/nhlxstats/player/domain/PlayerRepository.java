package com.mediatuotantoph.nhlxstats.player.domain;

/**
 * Class player repository.
 * @author Pirkka Huhtala
 *
 */
public interface PlayerRepository {

    public Player find(Integer id);

}