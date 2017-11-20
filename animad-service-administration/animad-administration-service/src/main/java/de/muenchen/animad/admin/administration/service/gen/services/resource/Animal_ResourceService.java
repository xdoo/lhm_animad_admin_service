package de.muenchen.animad.admin.administration.service.gen.services.resource;

import org.springframework.hateoas.Resource;

import de.muenchen.animad.admin.administration.service.gen.domain.Animal_;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
/**
 * Provides methods to alter resources before being sent to a client.
 */
public interface Animal_ResourceService {
	/**
	 * Process a resource. You can add links and alter the entity itself.
	 */
	Resource<Animal_> process(Resource<Animal_> resource);
}
