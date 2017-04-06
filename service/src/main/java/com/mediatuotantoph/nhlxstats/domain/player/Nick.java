package com.mediatuotantoph.nhlxstats.domain.player;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mediatuotantoph.nhlxstats.domain.Model;
import com.mediatuotantoph.nhlxstats.domain.franchise.Platform;

/**
 * Class for nickname which contains information about nick and platform
 * 
 * @author Pirkka Huhtala
 *
 */
@Document(collection = "nicks")
public class Nick extends Model {
    
    private String name;
    private Platform platform;
    
    public Nick() {
        // for mapping purposes
    }

    public Nick(String name, Platform platform) {
        this.name = name;
        this.platform = platform;
    }
    
    public boolean playsWithSamePlatform(Nick nick) {
        return this.platform == nick.platform;
    }

    public String getName() {
        return name;
    }
}
