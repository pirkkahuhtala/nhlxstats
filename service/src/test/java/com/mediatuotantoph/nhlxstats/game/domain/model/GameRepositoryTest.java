package com.mediatuotantoph.nhlxstats.game.domain.model;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mediatuotantoph.nhlxstats.configuration.Mongo;
import com.mediatuotantoph.nhlxstats.player.domain.Player;
import com.mediatuotantoph.nhlxstats.team.domain.Team;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Mongo.class})
public class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;

    @Before
    public void init() {
        gameRepository.deleteAll();
        Player homePlayer = new Player("Player 1");
        Team homeTeam = new Team("Team 1");
        Player visitorPlayer = new Player("Player 1");
        Team visitorTeam = new Team("Team 1");
        for (int i = 1; i <= 10; i++) {
            gameRepository.insert(new Game(new Date(), new Side(homePlayer, homeTeam, new Score()),
                    new Side(visitorPlayer, visitorTeam, new Score())));
        }
    }

    @Test
    public void testFindByHomePlayerIdOrVisitorPlayerId() throws Exception {
        
    }

}
