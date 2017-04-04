package com.mediatuotantoph.nhlxstats.domain.player.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.domain.player.Player;
import com.mediatuotantoph.nhlxstats.domain.player.PlayerRepository;
import com.mediatuotantoph.nhlxstats.domain.player.PlayerService;

/**
 * Class for player service implementation.
 * 
 * @author Pirkka Huhtala
 *
 */
@Service
public class DefaultPlayerService implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;
    
    @Override
    public Player find(String playerId) {
        return playerRepository.findOne(playerId);
    }

}