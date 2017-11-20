package de.muenchen.animad.admin.administration.service.gen.services.event;


import de.muenchen.animad.admin.administration.service.gen.domain.Enclosure_;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
/**
 * Provides methods to implement logic before and after Events.
 */
public interface Enclosure_EventService {
	void onAfterCreate(Enclosure_ entity);
	void onBeforeCreate(Enclosure_ entity);
	void onBeforeSave(Enclosure_ entity);
	void onAfterSave(Enclosure_ entity);
	void onBeforeLinkSave(Enclosure_ parent, Object linked);
	void onAfterLinkSave(Enclosure_ parent, Object linked);
	void onBeforeLinkDelete(Enclosure_ parent, Object linked);
	void onBeforeDelete(Enclosure_ entity);
	void onAfterDelete(Enclosure_ entity);
	void onAfterLinkDelete(Enclosure_ parent, Object linked);
}
