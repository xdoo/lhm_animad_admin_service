package de.muenchen.animad.admin.administration.service.gen.services.businessactions;

import java.util.Map;

import de.muenchen.animad.admin.administration.service.gen.domain.Animals_;

/**
 * Provides a service to execute business-actions.
 */
public interface CreateAppointment_BusinessActionService {
				
	/**
	 * This BusinessAction's purpose is: Create an appointment at the veterinarian for an animal
	 * It returns one java.time.LocalDateTime.
	 */
	java.time.LocalDateTime createAppointment(Map<String, Object> header, Animals_ species, String animalName, String reasonForAppointment);
}
