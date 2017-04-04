package com.mediatuotantoph.nhlxstats.domain;

import org.springframework.data.annotation.Id;

/**
 * Base class for entities
 * 
 * @author Pirkka Huhtala
 *
 */
public abstract class Model {

    @Id
    private String id;
    
    public Model() {}
    
    public Model(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
}