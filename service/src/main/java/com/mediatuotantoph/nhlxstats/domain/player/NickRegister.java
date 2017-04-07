package com.mediatuotantoph.nhlxstats.domain.player;

import com.mediatuotantoph.nhlxstats.domain.franchise.Platform;

/**
 * Interface for nickname registering
 * 
 * @author Pirkka Huhtala
 *
 */
public interface NickRegister {

    public Nick find(String playerHome);

    public Nick register(String name, Platform platform);

}