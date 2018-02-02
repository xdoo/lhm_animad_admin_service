package de.muenchen.animad.admin.administration.service.gen.rest.search;


import java.lang.reflect.Field;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.hibernate.search.exception.EmptyQueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.muenchen.service.QueryServiceChanged;
import de.muenchen.animad.admin.administration.service.gen.domain.Enclosure_;
import de.muenchen.animad.admin.administration.service.rest.Enclosure_Repository;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
@BasePathAwareController
@ExposesResourceFor(Enclosure_.class)
@RequestMapping("/enclosures/search")
public class Enclosure_SearchController {
		
    @Autowired
    QueryServiceChanged service;

    @Autowired
    Enclosure_Repository repository;

    @RequestMapping(method = RequestMethod.GET, value = "findFullTextFuzzy")
    @ResponseBody
    public ResponseEntity<?> findFullTextFuzzy(PersistentEntityResourceAssembler assembler, @Param("q") String q) {
        if (q == null)
            q = "";

		// Get all fields-names (including superclass fields) annotated with @Field
		List<String> annotatedFields = new ArrayList<String>();
	    Class tmpClass = Enclosure_.class;
	    while (tmpClass != null) {
		    annotatedFields.addAll(Stream.of(tmpClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(org.hibernate.search.annotations.Field.class))
                .map(Field::getName)
                .collect(Collectors.toList()));
        	tmpClass = tmpClass.getSuperclass();
	    }

        Stream<Enclosure_> enclosureStream;
        try {
            enclosureStream = service.query(q, Enclosure_.class, annotatedFields.toArray(new String[annotatedFields.size()])).stream();
        } catch (EmptyQueryException e) {
            enclosureStream = StreamSupport.stream(repository.findAll().spliterator(), false);
        }

        final List<PersistentEntityResource> collect = enclosureStream.map(assembler::toResource).collect(Collectors.toList());
        return new ResponseEntity<Object>(new Resources<>(collect), HttpStatus.OK);
	}

    /* NEW START */
    @RequestMapping(method = RequestMethod.GET, value ="findFullTextJunction")
    @ResponseBody
    public ResponseEntity<?> findFullTextJunction(PersistentEntityResourceAssembler assembler, @Param("q") String q){ if (q == null)
        q = "";

        List<String> annotatedFields = new ArrayList<>();
        Class tmpClass = Enclosure_.class;
        while (tmpClass != null) {
            annotatedFields.addAll(Stream.of(tmpClass.getDeclaredFields())
                    .filter(field -> field.isAnnotationPresent(org.hibernate.search.annotations.Field.class))
                    .map(Field::getName)
                    .collect(Collectors.toList()));
            tmpClass = tmpClass.getSuperclass();
        }



        Stream<Enclosure_> enclosureStream;

        try {
            enclosureStream = service.queryJunction(q, Enclosure_.class, annotatedFields.toArray(new String[annotatedFields.size()])).stream();
        } catch (EmptyQueryException e) {
            enclosureStream = StreamSupport.stream(repository.findAll().spliterator(), false);
        }

        final List<PersistentEntityResource> collect = enclosureStream.map(assembler::toResource).collect(Collectors.toList());
        return new ResponseEntity<Object>(new Resources<>(collect), HttpStatus.OK);
    }
    /* NEW END */
}


