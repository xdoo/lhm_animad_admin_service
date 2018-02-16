package de.muenchen.animad.admin.administration.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rowe42
 */
@RestController
public class OptionsController {

    private static final Logger LOG = Logger.getLogger(OptionsController.class.getName());

    /**
     * Resource without content.
     */
    class LinksResource extends ResourceSupport {

        public LinksResource() {
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/animalsOptions")
    public @ResponseBody
    ResponseEntity<LinksResource> getAnimalsOptions() {
        Link selfLink = linkTo(OptionsController.class)
                .slash("animals").withSelfRel();

        Link userServiceLink = linkTo(OptionsController.class)
                .slash("keepers").withRel("keepers");

        LinksResource links = new LinksResource();
        links.add(userServiceLink);
        links.add(selfLink);

        return new ResponseEntity<>(links, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/keepersOptions")
    public @ResponseBody
    ResponseEntity<LinksResource> getKeepersOptions() {
        Link selfLink = linkTo(OptionsController.class)
                .slash("keepers").withSelfRel();

        LinksResource links = new LinksResource();
        links.add(selfLink);

        return new ResponseEntity<>(links, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/enclosuresOptions")
    public @ResponseBody
    ResponseEntity<LinksResource> getEnclosuresOptions() {
        Link selfLink = linkTo(OptionsController.class)
                .slash("enclosures").withSelfRel();

        Link userServiceLink = linkTo(OptionsController.class)
                .slash("animals").withRel("animals");

        LinksResource links = new LinksResource();
        links.add(userServiceLink);
        links.add(selfLink);

        return new ResponseEntity<>(links, HttpStatus.OK);
    }

}
