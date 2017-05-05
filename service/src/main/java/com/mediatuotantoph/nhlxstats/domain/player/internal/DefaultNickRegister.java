package com.mediatuotantoph.nhlxstats.domain.player.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediatuotantoph.nhlxstats.domain.franchise.Platform;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.player.NickId;
import com.mediatuotantoph.nhlxstats.domain.player.NickRegister;
import com.mediatuotantoph.nhlxstats.domain.player.NickRepository;

/**
 * Implementation for nick refister
 * 
 * @author Pirkka Huhtala
 *
 */
@Service
public class DefaultNickRegister implements NickRegister {

    @Autowired
    private NickRepository nickRepository;

    @Override
    public Nick find(NickId nickId) {
        return nickRepository.findOne(nickId.value());
    }

    @Override
    public Nick register(String name, Platform platform) {
        // TODO: Create validation for existing nickname
        return nickRepository.save(new Nick(name, platform));
    }

    @Override
    public Nick createIfNotExists(String name, Platform platform) {
        Nick nick = find(name);
        if (nick == null) {
            nick = nickRepository.insert(new Nick(name, platform));
        }
        return nick;
    }

    private Nick find(String name) {
        return nickRepository.findOne(name);
    }

}