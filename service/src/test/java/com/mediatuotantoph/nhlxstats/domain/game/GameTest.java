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
        game = new Game(new Date(), new Opponent(new Nick("Player 1", Platform.PS), new Team("Toronto Maple Leafs")),
                new Opponent(new Nick("Player 2", Platform.PS), new Team("Chigago Black Hawks")),
                new Score(new Stats(), new Stats()));
    }

    @Test
    public void testEdit() {
        assertNull(game.getEditTime());
        Nick newPlayer1 = new Nick("Player 2", Platform.PS);
        Nick newPlayer2 = new Nick("Player 4", Platform.PS);
        Team newTeam1 = new Team("Anaheim Ducks");
        Team newTeam2 = new Team("San Jose Sharks");
        game.edit(new Opponent(newPlayer1, newTeam1), new Opponent(newPlayer2, newTeam2),
                new Score(new Stats(), new Stats()));
        assertEquals(newPlayer1, game.getPlayerHome());
        assertEquals(newTeam1, game.getTeamHome());
        assertEquals(newPlayer2, game.getPlayerVisitor());
        assertEquals(newTeam2, game.getTeamVisitor());
        assertNotNull(game.getEditTime());
    }

}