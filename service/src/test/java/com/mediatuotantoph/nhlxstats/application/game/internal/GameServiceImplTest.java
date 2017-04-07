package com.mediatuotantoph.nhlxstats.application.game.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mediatuotantoph.nhlxstats.application.game.GameDTO;
import com.mediatuotantoph.nhlxstats.application.game.GameService;
import com.mediatuotantoph.nhlxstats.application.game.StatsDTO;
import com.mediatuotantoph.nhlxstats.application.game.internal.GameServiceImplTest.AppConfig;
import com.mediatuotantoph.nhlxstats.configuration.Dozer;
import com.mediatuotantoph.nhlxstats.configuration.MongoConfigForTest;
import com.mediatuotantoph.nhlxstats.domain.game.GameRepository;
import com.mediatuotantoph.nhlxstats.domain.player.NickRepository;
import com.mediatuotantoph.nhlxstats.domain.team.Team;
import com.mediatuotantoph.nhlxstats.domain.team.TeamRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, MongoConfigForTest.class, Dozer.class })
public class GameServiceImplTest {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private NickRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Configuration
    @ComponentScan("com.mediatuotantoph.nhlxstats")
    public static class AppConfig {
    }

    @Autowired
    private GameService gameService;

    @Test
    public void testInsert() {

        gameRepository.deleteAll();
        playerRepository.deleteAll();
        teamRepository.deleteAll();

        Team homeTeam = new Team("Team 1");
        teamRepository.insert(homeTeam);
        Team visitorTeam = new Team("Team 2");
        teamRepository.insert(visitorTeam);

        GameDTO gameDTO = createGameDTO(homeTeam, visitorTeam);

        gameService.insert(gameDTO);

        assertNotNull(gameDTO.getId());

    }

    @Test
    public void testEdit() {

        gameRepository.deleteAll();
        playerRepository.deleteAll();
        teamRepository.deleteAll();

        Team homeTeam = new Team("Team1");
        teamRepository.insert(homeTeam);
        Team visitorTeam = new Team("Team2");
        teamRepository.insert(visitorTeam);

        GameDTO gameDTO = createGameDTO(homeTeam, visitorTeam);

        gameService.insert(gameDTO);

        homeTeam = new Team("Team3");
        teamRepository.insert(homeTeam);
        visitorTeam = new Team("Team4");
        teamRepository.insert(visitorTeam);

        gameDTO.setPlayerHomeName("Player3");
        gameDTO.setTeamHomeId(homeTeam.getId().value());
        gameDTO.setTeamVisitorId(visitorTeam.getId().value());
        gameDTO.setPlayerVisitorName("Player4");

        gameService.edit(gameDTO);

        assertEquals("Player3", gameDTO.getPlayerHomeName());
        assertEquals("Player4", gameDTO.getPlayerVisitorName());
        assertEquals(homeTeam.getId().value(), gameDTO.getTeamHomeId());
        assertEquals(visitorTeam.getId().value(), gameDTO.getTeamVisitorId());

    }

    @Test
    public void testFind() {

        gameRepository.deleteAll();
        playerRepository.deleteAll();
        teamRepository.deleteAll();

        Team homeTeam = new Team("Team 1");
        teamRepository.insert(homeTeam);
        Team visitorTeam = new Team("Team 2");
        teamRepository.insert(visitorTeam);

        GameDTO gameDTO = createGameDTO(homeTeam, visitorTeam);

        gameService.insert(gameDTO);

        GameDTO foundDTO = gameService.find(gameDTO.getId());

        assertEquals(gameDTO.getId(), foundDTO.getId());

    }

    private GameDTO createGameDTO(Team homeTeam, Team visitorTeam) {

        GameDTO gameDTO = new GameDTO();
        gameDTO.setDate(new Date());
        gameDTO.setPlayerHomeName("Player1");
        gameDTO.setPlayerVisitorName("Player 2");
        gameDTO.setTeamHomeId(homeTeam.getId().value());
        gameDTO.setTeamVisitorId(visitorTeam.getId().value());
        gameDTO.setStatsHome(new StatsDTO());
        gameDTO.setStatsVisitor(new StatsDTO());

        return gameDTO;
    }

}