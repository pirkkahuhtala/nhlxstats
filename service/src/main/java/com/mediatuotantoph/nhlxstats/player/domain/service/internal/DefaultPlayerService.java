package com.mediatuotantoph.nhlxstats.player.domain.service.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.player.domain.model.Player;
import com.mediatuotantoph.nhlxstats.player.domain.repository.PlayerRepository;
import com.mediatuotantoph.nhlxstats.player.domain.service.PlayerService;

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