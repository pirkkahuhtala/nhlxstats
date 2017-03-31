package com.mediatuotantoph.nhlxstats.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mediatuotantoph.nhlxstats.game.application.GameDTO;
import com.mediatuotantoph.nhlxstats.game.application.SideDTO;
import com.mediatuotantoph.nhlxstats.game.domain.model.Game;
import com.mediatuotantoph.nhlxstats.game.domain.model.Score;
import com.mediatuotantoph.nhlxstats.game.domain.model.Side;
import com.mediatuotantoph.nhlxstats.player.domain.Player;
import com.mediatuotantoph.nhlxstats.team.domain.Team;

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
        sideDTO.setPlayerId("1");
        sideDTO.setTeamId("2");
        Side side = mapper.map(sideDTO, Side.class);
        assertEquals("1", side.getPlayer().getId());
        assertEquals("2", side.getTeam().getId());
    }
    
    @Test
    public void testSide() {
        Player player = new Player("1", "Player 1");
        Team team = new Team("2", "Team 1");
        Score score = new Score();
        Side side = new Side(player, team, score);
        SideDTO sideDTO = mapper.map(side, SideDTO.class);
        assertEquals("1", sideDTO.getPlayerId());
        assertEquals("2", sideDTO.getTeamId());
    }
    
    @Test
    public void testGameDTO() {
        GameDTO gameDTO = new GameDTO();
        SideDTO home = new SideDTO();
        SideDTO visitor = new SideDTO();
        gameDTO.setDate(new Date());
        gameDTO.setHome(home);
        gameDTO.setVisitor(visitor);
        assertNotNull(mapper.map(gameDTO, Game.class));
    }
    
    @Test
    public void testGame() {
        Game game = new Game(new Date(), new Side(), new Side());        
        assertNotNull(mapper.map(game, GameDTO.class));
    }
    
}