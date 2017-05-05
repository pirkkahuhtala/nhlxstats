package com.mediatuotantoph.nhlxstats.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * Base class for entities
 * 
 * @author Pirkka Huhtala
 *
 */
public abstract class Entity<T extends EntityId<?>> {

    @Id
    private String id;
    @Transient
    private T modelId;

    public Entity() {
    }

    public Entity(String id) {
        this.id = id;
    }

    public T getId() {
        if (modelId == null) {
            modelId = wrapId(id);
        }
        return modelId;
    }

    protected abstract T wrapId(String id);

}