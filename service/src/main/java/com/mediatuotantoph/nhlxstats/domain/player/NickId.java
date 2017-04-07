package com.mediatuotantoph.nhlxstats.domain.player;

import com.mediatuotantoph.nhlxstats.domain.ModelId;

public class NickId extends ModelId<String> {

    public NickId() {
        super(null); // for mapping purposes
    }

    public NickId(String value) {
        super(value);
    }

}