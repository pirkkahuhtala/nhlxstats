package com.mediatuotantoph.nhlxstats.domain.game;

import static org.junit.Assert.*;

import java.util.Collection;
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
    private Nick player1;
    private Game game1;
    private Game game2;

    @Before
    public void init() {

        gameRepository.deleteAll();
        player1 = new Nick("555", Platform.PS);
        player1 = nickRepository.save(player1);
        Team player1Team = new Team("666");
        player1Team = teamRepository.save(player1Team);
        Nick player2 = new Nick("777", Platform.PS);
        player2 = nickRepository.save(player2);
        Team player2Team = new Team("888");
        player2Team = teamRepository.save(player2Team);

        game1 = gameRepository.insert(new Game(new Date(), new Opponent(player1, player1Team),
                new Opponent(player2, player2Team), new Score(new Stats(), new Stats())));
        game2 = gameRepository.insert(new Game(new Date(), new Opponent(player2, player2Team),
                new Opponent(player1, player1Team), new Score(new Stats(), new Stats())));

    }

    @Test
    public void testFindByHomePlayerNamePlayerId() throws Exception {
        String homePlayerNickId = player1.getId().value();
        Collection<Game> games = gameRepository.findByHomeNickIdOrVisitorNickId(homePlayerNickId, homePlayerNickId);
        assertFalse(games.isEmpty());
        assertEquals(2, games.size());
    }

}
