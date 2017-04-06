package com.mediatuotantoph.nhlxstats.application.player.internal;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.application.player.PlayerDTO;
import com.mediatuotantoph.nhlxstats.application.player.PlayerService;
import com.mediatuotantoph.nhlxstats.domain.player.NickRepository;

/**
 * 
 * Class for player service implementation
 * 
 * @author Pirkka Huhtala
 *
 */
@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private Mapper mapper;
    @Autowired
    private NickRepository playerRepository;

    @Override
    public PlayerDTO find(String id) {
        return mapper.map(playerRepository.findOne(id), PlayerDTO.class);
    }

}
