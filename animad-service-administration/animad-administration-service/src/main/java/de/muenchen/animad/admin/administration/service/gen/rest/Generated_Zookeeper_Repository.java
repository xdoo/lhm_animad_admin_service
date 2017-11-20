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

import de.muenchen.animad.admin.administration.service.gen.domain.Features_;
import de.muenchen.animad.admin.administration.service.gen.domain.Zookeeper_;

@NoRepositoryBean
public interface Generated_Zookeeper_Repository extends CrudRepository<Zookeeper_, UUID> {
	/**
	 * Name for the specific cache.
	 */
	String CACHE = "ZOOKEEPER_CACHE";
	
	/**
	 * Get all the Zookeeper_ entities.
	 *
	 * @return an Iterable of the Zookeeper_ entities with the same Tenancy.
	 */
	@Override
	Iterable<Zookeeper_> findAll();
	
	/**
	 * Get one specific Zookeeper_ by its unique oid.
	 *
	 * @param oid The identifier of the Zookeeper_.
	 * @return The Zookeeper_ with the requested oid.
	 */
	@Override
	@Cacheable(value = CACHE, key = "#p0")
	Zookeeper_ findOne(UUID oid);
	
	/**
	 * Create or update a Zookeeper_.
	 * <p>
	 * If the oid already exists, the Zookeeper_ will be overridden, hence update.
	 * If the oid does no already exist, a new Zookeeper_ will be created, hence create.
	 * </p>
	 *
	 * @param zookeeper The Zookeeper_ that will be saved.
	 * @return the saved Zookeeper_.
	 */
	@Override
	@CachePut(value = CACHE, key = "#p0.oid")
	//@PreAuthorize("hasAuthority('administration_WRITE_Zookeeper')")
	<S extends Zookeeper_> S save(S zookeeper);
	
	/**
	 * Delete the Zookeeper_ by a specified oid.
	 *
	 * @param oid the unique oid of the Zookeeper_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0")
	//@PreAuthorize("hasAuthority('administration_DELETE_Zookeeper')")
	void delete(UUID oid);
	
	/**
	 * Delete a Zookeeper_ by entity.
	 *
	 * @param entity The Zookeeper_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0.oid")
	//@PreAuthorize("hasAuthority('administration_DELETE_Zookeeper')")
	void delete(Zookeeper_ entity);
	
	/**
	 * Delete multiple Zookeeper_ entities by their oid.
	 *
	 * @param entities The Iterable of Zookeeper_ entities that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	//@PreAuthorize("hasAuthority('administration_DELETE_Zookeeper')")
	void delete(Iterable<? extends Zookeeper_> entities);
	
	/**
	 * Delete all Zookeeper_ entities.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	//@PreAuthorize("hasAuthority('administration_DELETE_Zookeeper')")
	void deleteAll();
	
	Zookeeper_ findByName(@Param(value= "name") String name);
	Zookeeper_ findByEmploymentDate(@Param(value= "employmentDate") java.time.LocalDate employmentDate);
	Zookeeper_ findByCanDo(@Param(value= "canDo") java.util.List<Features_> canDo);
	Zookeeper_ findByBirthday(@Param(value= "birthday") java.time.LocalDate birthday);
	Zookeeper_ findBySalary(@Param(value= "salary") long salary);
	List<Zookeeper_> findZookeeperByName(@Param("name") String name);
	List<Zookeeper_> findZookeeperByEmploymentDate(@Param("employmentDate") String employmentDate);
	
}
