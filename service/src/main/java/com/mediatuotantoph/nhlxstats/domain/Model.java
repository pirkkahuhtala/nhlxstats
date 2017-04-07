package com.mediatuotantoph.nhlxstats.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 * Base class for entities
 * 
 * @author Pirkka Huhtala
 *
 */
public abstract class Model<T extends ModelId<?>> {

    @Id
    private String id;
    @Transient
    private T modelId;

    public Model() {
    }

    public Model(String id) {
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