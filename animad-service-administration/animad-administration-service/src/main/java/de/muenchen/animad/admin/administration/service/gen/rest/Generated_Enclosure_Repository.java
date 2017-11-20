package de.muenchen.animad.admin.administration.service.gen.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.access.prepost.PreAuthorize;

import de.muenchen.animad.admin.administration.service.gen.domain.Enclosure_;

@NoRepositoryBean
public interface Generated_Enclosure_Repository extends CrudRepository<Enclosure_, UUID> {
	/**
	 * Name for the specific cache.
	 */
	String CACHE = "ENCLOSURE_CACHE";
	
	/**
	 * Get all the Enclosure_ entities.
	 *
	 * @return an Iterable of the Enclosure_ entities with the same Tenancy.
	 */
	@Override
	Iterable<Enclosure_> findAll();
	
	/**
	 * Get one specific Enclosure_ by its unique oid.
	 *
	 * @param oid The identifier of the Enclosure_.
	 * @return The Enclosure_ with the requested oid.
	 */
	@Override
	@Cacheable(value = CACHE, key = "#p0")
	Enclosure_ findOne(UUID oid);
	
	/**
	 * Create or update a Enclosure_.
	 * <p>
	 * If the oid already exists, the Enclosure_ will be overridden, hence update.
	 * If the oid does no already exist, a new Enclosure_ will be created, hence create.
	 * </p>
	 *
	 * @param enclosure The Enclosure_ that will be saved.
	 * @return the saved Enclosure_.
	 */
	@Override
	@CachePut(value = CACHE, key = "#p0.oid")
	//@PreAuthorize("hasAuthority('administration_WRITE_Enclosure')")
	<S extends Enclosure_> S save(S enclosure);
	
	/**
	 * Delete the Enclosure_ by a specified oid.
	 *
	 * @param oid the unique oid of the Enclosure_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0")
	//@PreAuthorize("hasAuthority('administration_DELETE_Enclosure')")
	void delete(UUID oid);
	
	/**
	 * Delete a Enclosure_ by entity.
	 *
	 * @param entity The Enclosure_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0.oid")
	//@PreAuthorize("hasAuthority('administration_DELETE_Enclosure')")
	void delete(Enclosure_ entity);
	
	/**
	 * Delete multiple Enclosure_ entities by their oid.
	 *
	 * @param entities The Iterable of Enclosure_ entities that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	//@PreAuthorize("hasAuthority('administration_DELETE_Enclosure')")
	void delete(Iterable<? extends Enclosure_> entities);
	
	/**
	 * Delete all Enclosure_ entities.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	//@PreAuthorize("hasAuthority('administration_DELETE_Enclosure')")
	void deleteAll();
	
	Enclosure_ findByEnclosureID(@Param(value= "enclosureID") String enclosureID);
	Enclosure_ findByCleaningTime(@Param(value= "cleaningTime") java.time.LocalTime cleaningTime);
	List<Enclosure_> findEnclosureByEnclosureID(@Param("enclosureID") String enclosureID);
	List<Enclosure_> findEnclosureByCleaningTime(@Param("cleaningTime") String cleaningTime);
	
	/**
	 * Find the Enclosure_ with a animals relation to the Animal with the given oid.
	 * @param oid the unique oid of the Animal that will be searched for in the animals relation.
	 */
	Enclosure_ findByAnimalsOid(@Param(value = "oid") UUID oid);
}
