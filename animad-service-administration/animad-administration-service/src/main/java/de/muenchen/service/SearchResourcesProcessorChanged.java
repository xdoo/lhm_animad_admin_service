//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package de.muenchen.service;

import org.springframework.data.rest.webmvc.RepositorySearchesResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class SearchResourcesProcessorChanged implements ResourceProcessor<RepositorySearchesResource> {
    public SearchResourcesProcessorChanged() {
    }

    public RepositorySearchesResource process(RepositorySearchesResource repositorySearchesResource) {
        String search = repositorySearchesResource.getId().getHref();
        Link findFullTextLucene = (new Link(search + "/findFullTextJunction{?q}")).withRel("findFullTextJunction");
        repositorySearchesResource.add(findFullTextLucene);
        return repositorySearchesResource;
    }
}