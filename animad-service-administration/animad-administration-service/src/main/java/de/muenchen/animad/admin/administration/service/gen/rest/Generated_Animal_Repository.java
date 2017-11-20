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
import java.math.BigDecimal;

import de.muenchen.animad.admin.administration.service.gen.domain.Animals_;
import de.muenchen.animad.admin.administration.service.gen.domain.Gender_;
import de.muenchen.animad.admin.administration.service.gen.domain.Animal_;

@NoRepositoryBean
public interface Generated_Animal_Repository extends CrudRepository<Animal_, UUID> {
	/**
	 * Name for the specific cache.
	 */
	String CACHE = "ANIMAL_CACHE";
	
	/**
	 * Get all the Animal_ entities.
	 *
	 * @return an Iterable of the Animal_ entities with the same Tenancy.
	 */
	@Override
	Iterable<Animal_> findAll();
	
	/**
	 * Get one specific Animal_ by its unique oid.
	 *
	 * @param oid The identifier of the Animal_.
	 * @return The Animal_ with the requested oid.
	 */
	@Override
	@Cacheable(value = CACHE, key = "#p0")
	Animal_ findOne(UUID oid);
	
	/**
	 * Create or update a Animal_.
	 * <p>
	 * If the oid already exists, the Animal_ will be overridden, hence update.
	 * If the oid does no already exist, a new Animal_ will be created, hence create.
	 * </p>
	 *
	 * @param animal The Animal_ that will be saved.
	 * @return the saved Animal_.
	 */
	@Override
	@CachePut(value = CACHE, key = "#p0.oid")
	//@PreAuthorize("hasAuthority('administration_WRITE_Animal')")
	<S extends Animal_> S save(S animal);
	
	/**
	 * Delete the Animal_ by a specified oid.
	 *
	 * @param oid the unique oid of the Animal_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0")
	//@PreAuthorize("hasAuthority('administration_DELETE_Animal')")
	void delete(UUID oid);
	
	/**
	 * Delete a Animal_ by entity.
	 *
	 * @param entity The Animal_ that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, key = "#p0.oid")
	//@PreAuthorize("hasAuthority('administration_DELETE_Animal')")
	void delete(Animal_ entity);
	
	/**
	 * Delete multiple Animal_ entities by their oid.
	 *
	 * @param entities The Iterable of Animal_ entities that will be deleted.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	//@PreAuthorize("hasAuthority('administration_DELETE_Animal')")
	void delete(Iterable<? extends Animal_> entities);
	
	/**
	 * Delete all Animal_ entities.
	 */
	@Override
	@CacheEvict(value = CACHE, allEntries = true)
	//@PreAuthorize("hasAuthority('administration_DELETE_Animal')")
	void deleteAll();
	
	Animal_ findByName(@Param(value= "name") String name);
	Animal_ findBySpecies(@Param(value= "species") Animals_ species);
	Animal_ findByBirthday(@Param(value= "birthday") java.time.LocalDate birthday);
	Animal_ findByGender(@Param(value= "gender") Gender_ gender);
	Animal_ findByWeight(@Param(value= "weight") BigDecimal weight);
	Animal_ findByAlive(@Param(value= "alive") boolean alive);
	List<Animal_> findAnimalByName(@Param("name") String name);
	List<Animal_> findAnimalBySpecies(@Param("species") String species);
	List<Animal_> findAnimalByBirthday(@Param("birthday") String birthday);
	
	/**
	 * Find the Animal_ entities with a keeper relation to the Zookeeper with the given oid.
	 * @param oid the unique oid of the Zookeeper that will be searched for in the keeper relation.
	 */
	java.util.List<Animal_> findByKeeperOid(@Param(value = "oid") UUID oid);
}
