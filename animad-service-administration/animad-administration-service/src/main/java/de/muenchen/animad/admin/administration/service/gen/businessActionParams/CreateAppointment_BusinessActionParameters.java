package de.muenchen.animad.admin.administration.service.gen.businessActionParams;

import de.muenchen.animad.admin.administration.service.gen.domain.Animals_;

public class CreateAppointment_BusinessActionParameters {
	private Animals_ species;
	private String animalName;
	private String reasonForAppointment;
	
	public Animals_ getSpecies(){return species;}
	
	public void setSpecies(Animals_ species){this.species = species;}
	
	public String getAnimalName(){return animalName;}
	
	public void setAnimalName(String animalName){this.animalName = animalName;}
	
	public String getReasonForAppointment(){return reasonForAppointment;}
	
	public void setReasonForAppointment(String reasonForAppointment){this.reasonForAppointment = reasonForAppointment;}
	
}
