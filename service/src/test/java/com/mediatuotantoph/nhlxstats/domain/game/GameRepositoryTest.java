package com.mediatuotantoph.nhlxstats.domain.game;

import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mediatuotantoph.nhlxstats.configuration.MongoConfigForTest;
import com.mediatuotantoph.nhlxstats.domain.franchise.Platform;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.player.NickRepository;
import com.mediatuotantoph.nhlxstats.domain.team.Team;
import com.mediatuotantoph.nhlxstats.domain.team.TeamRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MongoConfigForTest.class })
public class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private NickRepository nickRepository;
    @Autowired
    private TeamRepository teamRepository;
    private Game game;
    private Nick homePlayer;

    @Before
    public void init() {

        gameRepository.deleteAll();
        homePlayer = new Nick("555", Platform.PS);
        homePlayer = nickRepository.save(homePlayer);
        Team homeTeam = new Team("666");
        homeTeam = teamRepository.save(homeTeam);
        Nick visitorPlayer = new Nick("777", Platform.PS);
        visitorPlayer = nickRepository.save(visitorPlayer);
        Team visitorTeam = new Team("888");
        visitorTeam = teamRepository.save(visitorTeam);

        game = gameRepository.insert(new Game(new Date(), new Opponent(homePlayer, homeTeam),
                new Opponent(visitorPlayer, visitorTeam), new Score(new Stats(), new Stats())));

    }
    
    @Test
    public void testGetModelId() {
        game.getId();
    }

    @Test
    public void testFindByHomePlayerNamePlayerId() throws Exception {
        assertFalse(gameRepository.findByHomeNickId(homePlayer.getId().value()).isEmpty());
    }

}
