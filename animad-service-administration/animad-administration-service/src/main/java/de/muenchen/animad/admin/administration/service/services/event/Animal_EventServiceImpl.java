package de.muenchen.animad.admin.administration.service.services.event;

import org.springframework.stereotype.Service;

import de.muenchen.animad.admin.administration.service.gen.domain.Animal_;
import de.muenchen.animad.admin.administration.service.gen.services.event.Animal_EventService;

/*
 * This file will NOT be overwritten by GAIA.
 * This file was automatically generated by GAIA.
 */
/**
 * Provides methods to implement logic before and after Events.
 * If used as generated by GAIA this service will be autowired and called by Animal_EventListener.
 */
@Service
public class Animal_EventServiceImpl implements Animal_EventService{
	// If you need access to the database you can autowire a Repository.
	// Repositories are generated into the package: .gen.rest
	//
	// @Autowired
	// <EntityName>Repository repo;
	
	@Override
	public void onAfterCreate(Animal_ entity) {
		// Add your logic here.
	}
	@Override
	public void onBeforeCreate(Animal_ entity) {
		// Add your logic here.
	}
	@Override
	public void onBeforeSave(Animal_ entity) {
		// Add your logic here.
	}
	@Override
	public void onAfterSave(Animal_ entity) {
		// Add your logic here.
	}
	@Override
	public void onBeforeLinkSave(Animal_ parent, Object linked) {
		// Add your logic here.
	}
	@Override
	public void onAfterLinkSave(Animal_ parent, Object linked) {
		// Add your logic here.
	}
	@Override
	public void onBeforeLinkDelete(Animal_ parent, Object linked) {
		// Add your logic here.
	}
	@Override
	public void onBeforeDelete(Animal_ entity) {
		// Add your logic here.
	}
	@Override
	public void onAfterDelete(Animal_ entity) {
		// Add your logic here.
	}
	@Override
	public void onAfterLinkDelete(Animal_ parent, Object linked) {
		// Add your logic here.
	}
}
