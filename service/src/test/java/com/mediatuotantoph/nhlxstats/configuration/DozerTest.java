package com.mediatuotantoph.nhlxstats.configuration;

import static org.junit.Assert.assertEquals;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mediatuotantoph.nhlxstats.game.application.SideDTO;
import com.mediatuotantoph.nhlxstats.game.domain.model.Side;

/**
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
    public void testSideDTO() {
        SideDTO sideDTO = new SideDTO();
        sideDTO.setPlayerId(1);
        sideDTO.setTeamId(2);
        Side side = mapper.map(sideDTO, Side.class);
        assertEquals((Integer)1, side.getPlayer().getId());
        assertEquals((Integer)2, side.getTeam().getId());
    }
    
}