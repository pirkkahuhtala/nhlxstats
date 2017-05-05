package com.mediatuotantoph.nhlxstats.domain.game;

import com.mediatuotantoph.nhlxstats.domain.EntityId;

public class GameId extends EntityId<String> {

    public GameId() {
        super(null); // for maaping purposes
    }

    public GameId(String value) {
        super(value);
    }

}