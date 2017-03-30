package com.mediatuotantoph.nhlxstats.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
        return mapper;
    }
    
}