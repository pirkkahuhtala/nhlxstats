package com.mediatuotantoph.nhlxstats.domain.player;

import com.mediatuotantoph.nhlxstats.domain.franchise.Platform;

/**
 * Interface for nickname registering
 * 
 * @author Pirkka Huhtala
 *
 */
public interface NickRegister {

    public Nick find(String name);

    public Nick find(NickId nickId);

    public Nick register(String name, Platform platform);

    public Nick createIfNotExists(String playerHomeName, Platform platform);

}