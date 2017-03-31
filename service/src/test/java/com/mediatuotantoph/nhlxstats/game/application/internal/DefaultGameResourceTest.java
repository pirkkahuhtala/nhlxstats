package com.mediatuotantoph.nhlxstats.game.application.internal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.mediatuotantoph.nhlxstats.game.application.GameDTO;
import com.mediatuotantoph.nhlxstats.game.domain.model.Game;
import com.mediatuotantoph.nhlxstats.game.domain.model.GameService;
import com.mediatuotantoph.nhlxstats.game.domain.model.Side;
import com.mediatuotantoph.nhlxstats.player.application.PlayerDTO;
import com.mediatuotantoph.nhlxstats.player.domain.Player;
import com.mediatuotantoph.nhlxstats.player.domain.PlayerService;

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
        
        GameDTO gameDTO = mock(GameDTO.class);
        Game game = mock(Game.class);
        when(game.getHome()).thenReturn(mock(Side.class));
        when(game.getVisitor()).thenReturn(mock(Side.class));
        when(game.getHomePlayerId()).thenReturn(1);
        when(game.getVisitorPlayerId()).thenReturn(2);
        Player homePlayer = mock(Player.class);
        when(playerService.find(1)).thenReturn(homePlayer);
        Player visitorPlayer = mock(Player.class);
        when(playerService.find(2)).thenReturn(visitorPlayer);
        when(mapper.map(gameDTO, Game.class)).thenReturn(game);
        GameDTO newGameDTO = mock(GameDTO.class);
        when(mapper.map(game, GameDTO.class)).thenReturn(newGameDTO);
        
        gameResource.add(gameDTO);
        
        verify(game.getHome()).setPlayer(homePlayer);
        verify(game.getVisitor()).setPlayer(visitorPlayer);
        verify(gameService).add(game);
        verify(mapper).map(newGameDTO, gameDTO);
        
    }

    @Test
    public void testUpdate() throws Exception {

        GameDTO gameDTO = mock(GameDTO.class);
        Game game = mock(Game.class);
        when(game.getHome()).thenReturn(mock(Side.class));
        when(game.getVisitor()).thenReturn(mock(Side.class));
        when(game.getHomePlayerId()).thenReturn(1);
        when(game.getVisitorPlayerId()).thenReturn(2);
        Player homePlayer = mock(Player.class);
        when(playerService.find(1)).thenReturn(homePlayer);
        Player visitorPlayer = mock(Player.class);
        when(playerService.find(2)).thenReturn(visitorPlayer);
        when(mapper.map(gameDTO, Game.class)).thenReturn(game);
        GameDTO newGameDTO = mock(GameDTO.class);
        when(mapper.map(game, GameDTO.class)).thenReturn(newGameDTO);
        
        gameResource.update(gameDTO);
        
        verify(game.getHome()).setPlayer(homePlayer);
        verify(game.getVisitor()).setPlayer(visitorPlayer);
        verify(gameService).update(game);
        verify(mapper).map(newGameDTO, gameDTO);
        
    }

    @Test
    public void testDelete() throws Exception {
        
        GameDTO gameDTO = mock(GameDTO.class);
        Game game = mock(Game.class);
        when(game.getHome()).thenReturn(mock(Side.class));
        when(game.getVisitor()).thenReturn(mock(Side.class));
        when(game.getHomePlayerId()).thenReturn(1);
        when(game.getVisitorPlayerId()).thenReturn(2);
        Player homePlayer = mock(Player.class);
        when(playerService.find(1)).thenReturn(homePlayer);
        Player visitorPlayer = mock(Player.class);
        when(playerService.find(2)).thenReturn(visitorPlayer);
        when(mapper.map(gameDTO, Game.class)).thenReturn(game);
        GameDTO newGameDTO = mock(GameDTO.class);
        when(mapper.map(game, GameDTO.class)).thenReturn(newGameDTO);
        
        gameResource.delete(gameDTO);
        
        verify(game.getHome()).setPlayer(homePlayer);
        verify(game.getVisitor()).setPlayer(visitorPlayer);
        verify(gameService).delete(game);
        
    }

    @Test
    public void testFind() throws Exception {

        PlayerDTO playerDTO = mock(PlayerDTO.class);
        when(playerDTO.getId()).thenReturn(1);
        Player player = mock(Player.class);
        when(playerService.find(1)).thenReturn(player);
        
        gameResource.find(playerDTO);
        
        verify(gameService).find(player);
        
    }

}
