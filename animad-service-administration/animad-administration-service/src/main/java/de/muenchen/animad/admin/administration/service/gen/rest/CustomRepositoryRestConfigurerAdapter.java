/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.animad.admin.administration.service.gen.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 *
 * @author roland
 */
@Configuration
public class CustomRepositoryRestConfigurerAdapter extends RepositoryRestConfigurerAdapter {


   @Bean
   public Validator validator() {
       return new LocalValidatorFactoryBean();
   }

   @Override
   public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
       validatingListener.addValidator("afterCreate", validator());
       validatingListener.addValidator("beforeCreate", validator());
       validatingListener.addValidator("afterSave", validator());
       validatingListener.addValidator("beforeSave", validator());
   }
}
