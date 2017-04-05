package com.mediatuotantoph.nhlxstats.configuration;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mediatuotantoph.nhlxstats.application.game.GameDTO;
import com.mediatuotantoph.nhlxstats.domain.game.Game;

/**
 * Integration tests for Dozer mappings
 * 
 * @author Pirkka Huhtala
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Dozer.class)
public class DozerTest {
    
    @Autowired
    private Mapper mapper;

    @Test
    public void testGameDTOtoGame() {
        GameDTO gameDTO = new GameDTO();
        mapper.map(gameDTO, Game.class);
    }
    
    @Test
    public void testGametoGameDTO() {
        Game game = new Game();
        mapper.map(game, GameDTO.class);
    }
    
}