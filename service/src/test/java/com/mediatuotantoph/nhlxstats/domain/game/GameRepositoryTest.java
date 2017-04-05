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
import com.mediatuotantoph.nhlxstats.domain.player.Player;
import com.mediatuotantoph.nhlxstats.domain.player.PlayerRepository;
import com.mediatuotantoph.nhlxstats.domain.team.Team;
import com.mediatuotantoph.nhlxstats.domain.team.TeamRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MongoConfigForTest.class })
public class GameRepositoryTest {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;
    private Player visitorPlayer;
    private Player homePlayer;

    @Before
    public void init() {

        gameRepository.deleteAll();
        playerRepository.deleteAll();
        teamRepository.deleteAll();

        homePlayer = new Player("Player 1");
        playerRepository.insert(homePlayer);
        Team homeTeam = new Team("Team 1");
        teamRepository.insert(homeTeam);
        visitorPlayer = new Player("Player 2");
        playerRepository.insert(visitorPlayer);
        Team visitorTeam = new Team("Team 2");
        teamRepository.insert(visitorTeam);

        gameRepository.insert(new Game(new Date(), new Opponent(homePlayer, homeTeam),
                new Opponent(visitorPlayer, visitorTeam), new Score(new Stats(), new Stats())));

    }

    @Test
        public void testFindByHomePlayerNamePlayerId() throws Exception {
            assertFalse(gameRepository.findByHomePlayerId(homePlayer.getId()).isEmpty());
        }

}
