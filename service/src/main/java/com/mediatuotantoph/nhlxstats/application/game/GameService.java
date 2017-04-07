package com.mediatuotantoph.nhlxstats.application.game;

import java.util.Collection;

/**
 * Interface for game application service.
 * 
 * @author Pirkka Huhtala
 *
 */
public interface GameService {
    
    public GameDTO find(String id);

    public void insert(GameDTO gameDTO);
    
    public void edit(GameDTO gameDTO);
    
    public void delete(GameDTO gameDTO);

    public Collection<GameDTO> findByNickId(String id);

}