package com.mediatuotantoph.nhlxstats.configuration;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mediatuotantoph.nhlxstats.game.application.SideDTO;
import com.mediatuotantoph.nhlxstats.game.domain.model.Side;

/**
 * Class for Dozer mapper configuration
 * 
 * @author Pirkka Huhtala
 *
 */
@Configuration
public class Dozer {
    @Bean
    public DozerBeanMapper mapper() throws Exception {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(objectMappingBuilder);
        return mapper;
    }

    private BeanMappingBuilder objectMappingBuilder = new BeanMappingBuilder() {
        @Override
        protected void configure() {
            mapping(SideDTO.class, Side.class).fields("playerId", field("player.id").accessible()).fields("teamId",
                    field("team.id").accessible());
        }
    };
}