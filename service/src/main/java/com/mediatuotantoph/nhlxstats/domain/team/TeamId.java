package com.mediatuotantoph.nhlxstats.domain.team;

import com.mediatuotantoph.nhlxstats.domain.EntityId;

public class TeamId extends EntityId<String> {

    public TeamId() {
        super(null); // for mapping purposes
    }

    public TeamId(String value) {
        super(value);
    }

}