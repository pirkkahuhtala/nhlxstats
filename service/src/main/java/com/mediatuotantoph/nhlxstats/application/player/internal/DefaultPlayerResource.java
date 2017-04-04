package com.mediatuotantoph.nhlxstats.application.player.internal;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.application.player.PlayerDTO;
import com.mediatuotantoph.nhlxstats.application.player.PlayerResource;
import com.mediatuotantoph.nhlxstats.domain.player.PlayerRepository;

/**
 * 
 * Class for player resoure implementation
 * 
 * @author Pirkka Huhtala
 *
 */
@Service
public class DefaultPlayerResource implements PlayerResource {

    @Autowired
    private Mapper mapper;
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public PlayerDTO find(String id) {
        return mapper.map(playerRepository.findOne(id), PlayerDTO.class);
    }

}
