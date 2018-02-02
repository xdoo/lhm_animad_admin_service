package de.muenchen.animad.admin.administration.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//import de.muenchen.service.security.OAuth2RestTemplateConfig;

/**
 * Application class for starting the micro-service.
 */
@Configuration
@ComponentScan(basePackages = {"de.muenchen.animad.admin.administration.service", "de.muenchen.service", "de.muenchen.auditing", "de.muenchen.referenzarchitektur.authorisationLib"})
@EntityScan(basePackages = {"de.muenchen.animad.admin.administration.service", "de.muenchen.service", "de.muenchen.auditing"})
@EnableJpaRepositories(basePackages = {"de.muenchen.animad.admin.administration.service", "de.muenchen.service", "de.muenchen.auditing"})
@EnableAutoConfiguration
//@EnableEurekaClient
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableResourceServer
public class MicroServiceApplication {
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(MicroServiceApplication.class, args);
    }
    
}
