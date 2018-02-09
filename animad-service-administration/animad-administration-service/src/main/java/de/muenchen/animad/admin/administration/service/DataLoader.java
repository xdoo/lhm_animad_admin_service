/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.animad.admin.administration.service;

import de.muenchen.animad.admin.administration.service.gen.services.businessactions.TestDatenBusinessActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author robert.jasny
 */
@Component
public class DataLoader implements ApplicationRunner {

     @Autowired
    TestDatenBusinessActionService testDatenBusinessActionService;

    public void run(ApplicationArguments args) {
        testDatenBusinessActionService.testdatenErzeugen();
    }
}

