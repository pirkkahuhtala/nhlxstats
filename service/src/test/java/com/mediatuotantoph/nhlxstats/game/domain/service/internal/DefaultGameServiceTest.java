package com.mediatuotantoph.nhlxstats.game.domain.service.internal;

import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mediatuotantoph.nhlxstats.game.domain.model.Game;
import com.mediatuotantoph.nhlxstats.game.domain.model.Score;
import com.mediatuotantoph.nhlxstats.game.domain.model.Side;
import com.mediatuotantoph.nhlxstats.game.domain.repository.GameRepository;
import com.mediatuotantoph.nhlxstats.player.domain.model.Player;
import com.mediatuotantoph.nhlxstats.team.domain.model.Team;

@RunWith(MockitoJUnitRunner.class)
public class DefaultGameServiceTest {

    @InjectMocks
    private DefaultGameService gameService = new DefaultGameService();
    @Mock
    private GameRepository gameRepository;

    @Test
    public void testAdd() throws Exception {

        Player homePlayer = new Player("1", "Player 1");
        Team homeTeam = new Team("1", "Toronto Maple Leafs");
        Player visitorPlayer = new Player("2", "Player 2");
        Team visitorTeam = new Team("2", "Chicago Blackhawks");
        Game game = new Game(new Date(), new Side(homePlayer, homeTeam, new Score()),
                new Side(visitorPlayer, visitorTeam, new Score()));

        gameService.add(game);

        verify(gameRepository).insert(game);

    }

    @Test
    public void testUpdate() throws Exception {

        Player homePlayer = new Player("1", "Player 1");
        Team homeTeam = new Team("1", "Toronto Maple Leafs");
        Player visitorPlayer = new Player("2", "Player 2");
        Team visitorTeam = new Team("2", "Chicago Blackhawks");
        Game game = new Game(new Date(), new Side(homePlayer, homeTeam, new Score()),
                new Side(visitorPlayer, visitorTeam, new Score()));

        gameService.update(game);

        verify(gameRepository).save(game);

    }

    @Test
    public void testDelete() throws Exception {

        Player homePlayer = new Player("1", "Player 1");
        Team homeTeam = new Team("1", "Toronto Maple Leafs");
        Player visitorPlayer = new Player("2", "Player 2");
        Team visitorTeam = new Team("2", "Chicago Blackhawks");
        Game game = new Game(new Date(), new Side(homePlayer, homeTeam, new Score()),
                new Side(visitorPlayer, visitorTeam, new Score()));

        gameService.delete(game);

        verify(gameRepository).delete(game);

    }

    @Test
    public void testFind() throws Exception {

        Player player = new Player("1", "Player 1");

        gameService.find(player);

        verify(gameRepository).findByHomePlayerId(player.getId());

    }

}
