package com.mediatuotantoph.nhlxstats.domain.player;

import com.mediatuotantoph.nhlxstats.domain.EntityId;

public class NickId extends EntityId<String> {

    public NickId() {
        super(null); // for mapping purposes
    }

    public NickId(String value) {
        super(value);
    }

}