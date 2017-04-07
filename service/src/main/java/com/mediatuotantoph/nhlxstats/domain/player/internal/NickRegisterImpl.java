package com.mediatuotantoph.nhlxstats.domain.player.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.domain.franchise.Platform;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.player.NickRegister;
import com.mediatuotantoph.nhlxstats.domain.player.NickRepository;

/**
 * Implementation for nick refister
 * 
 * @author Pirkka Huhtala
 *
 */
@Service
public class NickRegisterImpl implements NickRegister {

    @Autowired
    private NickRepository nickRepository;

    @Override
    public Nick find(String nick) {
        return nickRepository.findOne(nick);
    }

    @Override
    public Nick register(String name, Platform platform) {
        // TODO: Create validation for existing nickname
        return nickRepository.save(new Nick(name, platform));
    }

}