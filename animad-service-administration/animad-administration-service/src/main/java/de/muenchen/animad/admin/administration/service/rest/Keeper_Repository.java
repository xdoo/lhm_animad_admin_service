package de.muenchen.animad.admin.administration.service.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import de.muenchen.animad.admin.administration.service.gen.domain.Features_;
import de.muenchen.animad.admin.administration.service.gen.domain.Keeper_;

/**
* Provides a Repository for a {@link Keeper_}. This Repository can be exported as a REST Resource.
* <p>
* The Repository handles CRUD Operations. Every Operation is secured and takes care of the tenancy.
* For specific Documentation on how the generated REST point behaves, please consider the Spring Data Rest Reference
* <a href="http://docs.spring.io/spring-data/rest/docs/current/reference/html/">here</a>.
* </p>
*/
@RepositoryRestResource(exported = true,
	path="keepers", collectionResourceRel="keepers")
@PreAuthorize("hasPermission(T(de.muenchen.animad.admin.administration.security.ResourcesEnum).administration_READ_Keeper.name(), 'Entitlements')")
public interface Keeper_Repository extends de.muenchen.animad.admin.administration.service.gen.rest.Generated_Keeper_Repository {
}
