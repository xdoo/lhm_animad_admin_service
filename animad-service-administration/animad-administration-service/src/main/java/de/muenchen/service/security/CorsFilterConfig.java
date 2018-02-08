package de.muenchen.service.security;

import de.muenchen.service.security.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration to enable {@link CorsFilter}.
 */
@Configuration
public class CorsFilterConfig {

    @Bean
    public CorsFilter corsFilter(){
        return new CorsFilter();
    }
}
