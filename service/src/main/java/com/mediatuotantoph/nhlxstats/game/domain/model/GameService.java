package com.mediatuotantoph.nhlxstats.game.domain.model;

import java.util.Collection;
import java.util.Date;

/**
 * Interface for game service
 * 
 * @author Pirkka Huhtala
 *
 */
public interface GameService {

    public void add(Game game);

    public void update(int gameId, Date date, int homePlayerId, Score homeScore, int visitorPlayerId, Score visitorScore);

    public void delete(int gameId);
    
    public Collection<Game> find(int id);

}
