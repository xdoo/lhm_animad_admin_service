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
import de.muenchen.animad.admin.administration.service.gen.domain.Keeper_;

@NoRepositoryBean
public interface Generated_Keeper_Repository extends CrudRepository<Keeper_, UUID> {
	/**
	 * Name for the specific cache.
	 */
	String CACHE = "KEEPER_CACHE";
	
	/**
	 * Get all the Keeper_ entities.
	 *
	 * @return an Iterable of the Keeper_ entities with the same Tenancy.
	 */
	@Override
	Iterable<Keeper_> findAll();
	
	/**
	 * Get one specific Keeper_ by its unique oid.
	 *
	 * @param oid The identifier of the Keeper_.
	 * @return The Keeper_ with the requested oid.
	 */
	@Override
	@Cacheable(value = CACHE, key = "#p0")
	Keeper_ findOne(UUID oid);
	
	/**
	 * Create or update a Keeper_.
	 * <p>
	 * If the oid already exists, the Keeper_ will be overridden, hence update.
	 * If the oid does no already exist, a new Keeper_ will be created, hence create.
	 * </p>
	 *
	 * @param keeper The Keeper_ that will be saved.
	 * @return the saved Keeper_.
	 */
	@Override
	@CachePut(value = CACHE, key = "#p0.oid")
	//@PreAuthorize("hasAuthority('administration_WRITE_Keeper')")
	<S extends Keeper_> S save(S keeper);
	
	/**
	 * Delete the Keeper_ by a specified oid.
	 *
	 * @param oid the unique oid of the Keeper_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0")
	//@PreAuthorize("hasAuthority('administration_DELETE_Keeper')")
	void delete(UUID oid);
	
	/**
	 * Delete a Keeper_ by entity.
	 *
	 * @param entity The Keeper_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0.oid")
	//@PreAuthorize("hasAuthority('administration_DELETE_Keeper')")
	void delete(Keeper_ entity);
	
	/**
	 * Delete multiple Keeper_ entities by their oid.
	 *
	 * @param entities The Iterable of Keeper_ entities that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	//@PreAuthorize("hasAuthority('administration_DELETE_Keeper')")
	void delete(Iterable<? extends Keeper_> entities);
	
	/**
	 * Delete all Keeper_ entities.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	//@PreAuthorize("hasAuthority('administration_DELETE_Keeper')")
	void deleteAll();
	
	Keeper_ findByFirstName(@Param(value= "firstName") String firstName);
	Keeper_ findByLastName(@Param(value= "lastName") String lastName);
	Keeper_ findByEmploymentDate(@Param(value= "employmentDate") java.time.LocalDate employmentDate);
	Keeper_ findBySkill(@Param(value= "skill") java.util.List<Features_> skill);
	Keeper_ findByBirthday(@Param(value= "birthday") java.time.LocalDate birthday);
	Keeper_ findBySalary(@Param(value= "salary") long salary);
	List<Keeper_> findKeeperByFirstName(@Param("firstName") String firstName);
	List<Keeper_> findKeeperByLastName(@Param("lastName") String lastName);
	List<Keeper_> findKeeperByEmploymentDate(@Param("employmentDate") String employmentDate);
	
}
