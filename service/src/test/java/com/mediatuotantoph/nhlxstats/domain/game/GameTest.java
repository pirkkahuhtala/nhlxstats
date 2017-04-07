package com.mediatuotantoph.nhlxstats.domain.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.mediatuotantoph.nhlxstats.domain.franchise.Platform;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game(new Date(), new Opponent(new Nick("1", Platform.PS), new Team("1")),
                new Opponent(new Nick("2", Platform.PS), new Team("2")), new Score(new Stats(), new Stats()));
    }

    @Test
    public void testEdit() {
        assertNull(game.getEditTime());
        Nick newPlayer1 = new Nick("3", Platform.PS);
        Nick newPlayer2 = new Nick("4", Platform.PS);
        Team newTeam1 = new Team("3");
        Team newTeam2 = new Team("4");
        game.edit(new Opponent(newPlayer1, newTeam1), new Opponent(newPlayer2, newTeam2),
                new Score(new Stats(), new Stats()));
        assertEquals(newPlayer1, game.getPlayerHome());
        assertEquals(newTeam1, game.getTeamHome());
        assertEquals(newPlayer2, game.getPlayerVisitor());
        assertEquals(newTeam2, game.getTeamVisitor());
        assertNotNull(game.getEditTime());
    }

}