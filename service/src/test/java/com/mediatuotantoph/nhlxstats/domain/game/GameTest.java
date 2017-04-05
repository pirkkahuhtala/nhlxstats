package com.mediatuotantoph.nhlxstats.domain.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.mediatuotantoph.nhlxstats.domain.player.Player;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game(new Date(), new Opponent(new Player("Player 1"), new Team("Toronto Maple Leafs")),
                new Opponent(new Player("Player 2"), new Team("Chigago Black Hawks")),
                new Score(new Stats(), new Stats()));
    }

    @Test
    public void testEdit() {
        assertNull(game.getEditTime());
        Player newPlayer1 = new Player("Player 2");
        Player newPlayer2 = new Player("Player 4");
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