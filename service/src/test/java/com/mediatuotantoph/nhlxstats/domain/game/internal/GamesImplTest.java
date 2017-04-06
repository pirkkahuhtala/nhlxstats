package com.mediatuotantoph.nhlxstats.domain.game.internal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mediatuotantoph.nhlxstats.domain.franchise.GameVersion;
import com.mediatuotantoph.nhlxstats.domain.game.Game;
import com.mediatuotantoph.nhlxstats.domain.game.GameFactory;
import com.mediatuotantoph.nhlxstats.domain.game.GameRepository;
import com.mediatuotantoph.nhlxstats.domain.game.Score;
import com.mediatuotantoph.nhlxstats.domain.player.Nick;
import com.mediatuotantoph.nhlxstats.domain.player.NickRegister;
import com.mediatuotantoph.nhlxstats.domain.team.Team;
import com.mediatuotantoph.nhlxstats.domain.team.TeamRepository;

@RunWith(MockitoJUnitRunner.class)
public class GamesImplTest {

    @InjectMocks
    private GamesImpl games = new GamesImpl();
    @Mock
    private NickRegister nickRegister;
    @Mock
    private TeamRepository teamRepository;
    @Mock
    private GameFactory gameFactory;
    @Mock
    private GameRepository gameRepository;

    @Test
    public void testInsert() throws Exception {

        Date date = mock(Date.class);
        Nick player1 = mock(Nick.class);
        Nick player2 = mock(Nick.class);
        Team team1 = mock(Team.class);
        Team team2 = mock(Team.class);
        Score score = mock(Score.class);
        Game game = mock(Game.class);
        GameVersion version = mock(GameVersion.class);

        when(nickRegister.find("Player1")).thenReturn(player1);
        when(nickRegister.find("Player2")).thenReturn(player2);
        when(teamRepository.findOne("1")).thenReturn(team1);
        when(teamRepository.findOne("2")).thenReturn(team2);
        when(gameFactory.create(date, player1, player2, team1, team2, score)).thenReturn(game);

        assertEquals(game, games.insert(date, "Player1", "Player2", "1", "2", score, version));

        verify(nickRegister).find("Player1");
        verify(nickRegister).find("Player2");
        verify(teamRepository).findOne("1");
        verify(teamRepository).findOne("2");
        verify(gameFactory).create(date, player1, player2, team1, team2, score);
        verify(gameRepository).insert(game);

    }

}
