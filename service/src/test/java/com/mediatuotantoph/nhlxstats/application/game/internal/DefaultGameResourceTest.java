package com.mediatuotantoph.nhlxstats.application.game.internal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mediatuotantoph.nhlxstats.application.game.GameDTO;
import com.mediatuotantoph.nhlxstats.application.game.ScoreDTO;
import com.mediatuotantoph.nhlxstats.application.game.SideDTO;
import com.mediatuotantoph.nhlxstats.application.game.internal.DefaultGameResource;
import com.mediatuotantoph.nhlxstats.domain.game.Game;
import com.mediatuotantoph.nhlxstats.domain.game.GameService;
import com.mediatuotantoph.nhlxstats.domain.game.Score;
import com.mediatuotantoph.nhlxstats.domain.game.Side;
import com.mediatuotantoph.nhlxstats.domain.player.Player;
import com.mediatuotantoph.nhlxstats.domain.player.PlayerService;
import com.mediatuotantoph.nhlxstats.domain.team.Team;

@RunWith(MockitoJUnitRunner.class)
public class DefaultGameResourceTest {

    @InjectMocks
    private DefaultGameResource gameResource = new DefaultGameResource();
    @Mock
    private GameService gameService;
    @Mock
    private PlayerService playerService;
    @Mock
    private Mapper mapper;

    @Test
    public void testAdd() throws Exception {
        
        Player homePlayer = new Player("1", "Player 1");
        Team homeTeam = new Team("2", "Toronto Maple Leafs");
        Player visitorPlayer = new Player("3", "Player 2");
        Team visitorTeam = new Team("4", "Chicago Blackhawks");
        Game game = new Game(new Date(), new Side(homePlayer, homeTeam, new Score()),
                new Side(visitorPlayer, visitorTeam, new Score()));
        
        GameDTO gameDTO = new GameDTO();
        
        SideDTO homeSideDTO = new SideDTO();
        homeSideDTO.setPlayerId("1");
        homeSideDTO.setTeamId("2");
        homeSideDTO.setScore(new ScoreDTO());
        gameDTO.setHome(homeSideDTO);
        
        SideDTO visitorSideDTO = new SideDTO();
        visitorSideDTO.setPlayerId("3");
        visitorSideDTO.setTeamId("4");
        visitorSideDTO.setScore(new ScoreDTO());
        gameDTO.setVisitor(visitorSideDTO);
        
        when(mapper.map(gameDTO, Game.class)).thenReturn(game);
        when(playerService.find("1")).thenReturn(homePlayer);
        when(playerService.find("3")).thenReturn(visitorPlayer);
        GameDTO newGameDTO = mock(GameDTO.class);
        when(mapper.map(game, GameDTO.class)).thenReturn(newGameDTO);
        
        gameResource.add(gameDTO);
        
        verify(mapper).map(gameDTO, Game.class);
        verify(playerService).find("1");
        verify(playerService).find("3");
        verify(gameService).add(game);
        verify(mapper).map(newGameDTO, gameDTO);
        
    }

    @Test
    public void testUpdate() throws Exception {

        Player homePlayer = new Player("1", "Player 1");
        Team homeTeam = new Team("2", "Toronto Maple Leafs");
        Player visitorPlayer = new Player("3", "Player 2");
        Team visitorTeam = new Team("4", "Chicago Blackhawks");
        Game game = new Game(new Date(), new Side(homePlayer, homeTeam, new Score()),
                new Side(visitorPlayer, visitorTeam, new Score()));
        
        GameDTO gameDTO = new GameDTO();
        
        SideDTO homeSideDTO = new SideDTO();
        homeSideDTO.setPlayerId("1");
        homeSideDTO.setTeamId("2");
        homeSideDTO.setScore(new ScoreDTO());
        gameDTO.setHome(homeSideDTO);
        
        SideDTO visitorSideDTO = new SideDTO();
        visitorSideDTO.setPlayerId("3");
        visitorSideDTO.setTeamId("4");
        visitorSideDTO.setScore(new ScoreDTO());
        gameDTO.setVisitor(visitorSideDTO);
        
        when(mapper.map(gameDTO, Game.class)).thenReturn(game);
        when(playerService.find("1")).thenReturn(homePlayer);
        when(playerService.find("3")).thenReturn(visitorPlayer);
        GameDTO newGameDTO = mock(GameDTO.class);
        when(mapper.map(game, GameDTO.class)).thenReturn(newGameDTO);
        
        gameResource.update(gameDTO);
        
        verify(mapper).map(gameDTO, Game.class);
        verify(playerService).find("1");
        verify(playerService).find("3");
        verify(gameService).update(game);
        verify(mapper).map(newGameDTO, gameDTO);
        
    }

    @Test
    public void testDelete() throws Exception {
        
        Player homePlayer = new Player("1", "Player 1");
        Team homeTeam = new Team("2", "Toronto Maple Leafs");
        Player visitorPlayer = new Player("3", "Player 2");
        Team visitorTeam = new Team("4", "Chicago Blackhawks");
        Game game = new Game(new Date(), new Side(homePlayer, homeTeam, new Score()),
                new Side(visitorPlayer, visitorTeam, new Score()));
        
        GameDTO gameDTO = new GameDTO();
        
        SideDTO homeSideDTO = new SideDTO();
        homeSideDTO.setPlayerId("1");
        homeSideDTO.setTeamId("2");
        homeSideDTO.setScore(new ScoreDTO());
        gameDTO.setHome(homeSideDTO);
        
        SideDTO visitorSideDTO = new SideDTO();
        visitorSideDTO.setPlayerId("3");
        visitorSideDTO.setTeamId("4");
        visitorSideDTO.setScore(new ScoreDTO());
        gameDTO.setVisitor(visitorSideDTO);
        
        when(mapper.map(gameDTO, Game.class)).thenReturn(game);
        when(playerService.find("1")).thenReturn(homePlayer);
        when(playerService.find("3")).thenReturn(visitorPlayer);
        
        gameResource.delete(gameDTO);
        
        verify(mapper).map(gameDTO, Game.class);
        verify(playerService).find("1");
        verify(playerService).find("3");
        verify(gameService).delete(game);
        
    }

    @Test
    public void testFind() throws Exception {

        Player player = mock(Player.class);
        when(playerService.find("1")).thenReturn(player);
        
        gameResource.findByPlayerId("1");
        
        verify(playerService).find("1");
        verify(gameService).find(player);
        
    }

}
