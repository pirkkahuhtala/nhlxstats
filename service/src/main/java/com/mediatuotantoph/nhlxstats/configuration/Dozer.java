package com.mediatuotantoph.nhlxstats.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mediatuotantoph.nhlxstats.application.game.GameDTO;
import com.mediatuotantoph.nhlxstats.domain.game.Game;

/**
 * Class for Dozer mapper configuration
 * 
 * @author Pirkka Huhtala
 *
 */
@Configuration
public class Dozer {

    @Bean
    public DozerBeanMapper createMapper() throws Exception {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(GameDTO.class, Game.class).fields("id", field("id").accessible())
                        .fields("playerHomeName", field("home.nick.name").accessible())
                        .fields("playerVisitorName", field("visitor.nick.name").accessible())
                        .fields("teamHomeId", field("home.team.id").accessible())
                        .fields("teamVisitorId", field("visitor.team.id").accessible())
                        .fields("statsHome", field("score.home").accessible())
                        .fields("statsVisitor", field("score.visitor").accessible());
            }
        });
        return mapper;
    }

}