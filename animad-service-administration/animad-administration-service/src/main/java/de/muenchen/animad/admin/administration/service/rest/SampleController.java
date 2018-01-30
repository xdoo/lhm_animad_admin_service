/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.muenchen.animad.admin.administration.service.rest;

import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
@BasePathAwareController
public class SampleController {

    /**
     * Resource without content.
     */
    class RootLinksResource extends ResourceSupport {

        public RootLinksResource() {
        }
    }

    @RequestMapping(method = RequestMethod.OPTIONS, path = "/enclosures")
    public @ResponseBody
    ResponseEntity<RootLinksResource> getActions() {
        System.out.println("Hit Options!");
        //these lines need to be generated...
        //duplication to application.yml --> can this be somehow be avoided?        
        Link selfLink = linkTo(SampleController.class)
                .slash("enclosures").withRel("self");
        Link animalsLink = linkTo(SampleController.class)
                .slash("animals").withRel("animals");

        RootLinksResource links = new RootLinksResource();
        links.add(selfLink);
        links.add(animalsLink);

        return new ResponseEntity<>(links, HttpStatus.OK);
    }
    
        @RequestMapping(method = RequestMethod.DELETE, path = "/enclosures")
    public @ResponseBody
    ResponseEntity<RootLinksResource> test() {
        System.out.println("Hit Delete!");
        //these lines need to be generated...
        //duplication to application.yml --> can this be somehow be avoided?        
        Link selfLink = linkTo(SampleController.class)
                .slash("enclosures").withRel("self");
        Link animalsLink = linkTo(SampleController.class)
                .slash("animals").withRel("animals");

        RootLinksResource links = new RootLinksResource();
        links.add(selfLink);
        links.add(animalsLink);

        return new ResponseEntity<>(links, HttpStatus.OK);
    }

    
}
