/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.animad.admin.administration.service;

import de.muenchen.animad.admin.administration.service.gen.domain.Animal_;
import de.muenchen.animad.admin.administration.service.gen.domain.Animals_;
import de.muenchen.animad.admin.administration.service.gen.domain.Enclosure_;
import de.muenchen.animad.admin.administration.service.gen.domain.Features_;
import de.muenchen.animad.admin.administration.service.gen.domain.Gender_;
import de.muenchen.animad.admin.administration.service.gen.domain.Zookeeper_;
import de.muenchen.animad.admin.administration.service.rest.Animal_Repository;
import de.muenchen.animad.admin.administration.service.rest.Enclosure_Repository;
import de.muenchen.animad.admin.administration.service.rest.Zookeeper_Repository;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
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
    Enclosure_Repository enclosureRepo;
    @Autowired
    Animal_Repository animalRepo;
    @Autowired
    Zookeeper_Repository zookeeperRepo;

    public void run(ApplicationArguments args) {
        testdatenErzeugen();
    }

    private void testdatenErzeugen() {

        System.out.println("############ Create Test Data ##############");

        //insert example data for Enclosures
        Enclosure_ enclosure = new Enclosure_();
        enclosure.setEnclosureID("Elephant's Paradise");
        enclosure.setCleaningTime(java.time.LocalTime.parse("15:15:15", java.time.format.DateTimeFormatter.ofPattern("k:mm:ss")));
        enclosure.setOid(UUID.randomUUID());

        //insert example data for Zookeepers
        Zookeeper_ zookeeper = new Zookeeper_();
        zookeeper.setName("Claus");
        zookeeper.setEmploymentDate(java.time.LocalDate.parse("01.01.2017", java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        zookeeper.setCanDo(new java.util.ArrayList<>(Arrays.asList(Features_.cleaning)));
        zookeeper.setBirthday(java.time.LocalDate.parse("04.08.1974", java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        zookeeper.setSalary(450L);
        zookeeper.setOid(UUID.randomUUID());

        // insert example data for Animals
        // Benjamin
        Animal_ animal1 = new Animal_();
        animal1.setName("Benjamin");
        animal1.setSpecies(Animals_.Elephant);
        animal1.setBirthday(java.time.LocalDate.parse("01.01.1967", java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        animal1.setGender(Gender_.male);
        animal1.setWeight(new BigDecimal("2450.0"));
        animal1.setAlive(true);
        animal1.setOid(UUID.randomUUID());

        // Dumbo
        Animal_ animal2 = new Animal_();
        animal2.setName("Dumbo");
        animal2.setSpecies(Animals_.Elephant);
        animal2.setBirthday(java.time.LocalDate.parse("01.01.1998", java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        animal2.setGender(Gender_.male);
        animal2.setWeight(new BigDecimal("1350.0"));
        animal2.setAlive(true);
        animal2.setOid(UUID.randomUUID());
        
        List<Animal_> animals = new java.util.ArrayList<Animal_>(Arrays.asList(animal1, animal2));
        
        // Set relations
        animal1.setKeeper(new java.util.ArrayList<>(Arrays.asList(zookeeper)));
        animal2.setKeeper(new java.util.ArrayList<>(Arrays.asList(zookeeper)));
        enclosure.setAnimals(animals);

        //Save all example Entities in an order that won't cause errors
        //zookeeperRepo.save(zookeeper);
        enclosureRepo.save(enclosure);
        //animalRepo.save(animal1);

    }
}
