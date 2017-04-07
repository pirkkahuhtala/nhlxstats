package com.mediatuotantoph.nhlxstats.domain.game;

import com.mediatuotantoph.nhlxstats.domain.ModelId;

public class GameId extends ModelId<String> {

    public GameId() {
        super(null); // for maaping purposes
    }

    public GameId(String value) {
        super(value);
    }

}