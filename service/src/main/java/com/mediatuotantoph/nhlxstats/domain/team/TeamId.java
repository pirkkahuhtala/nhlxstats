package com.mediatuotantoph.nhlxstats.domain.team;

import com.mediatuotantoph.nhlxstats.domain.ModelId;

public class TeamId extends ModelId<String> {

    public TeamId() {
        super(null); // for mapping purposes
    }

    public TeamId(String value) {
        super(value);
    }

}