package de.muenchen.animad.admin.administration.service.gen.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;	
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ElementCollection;
import javax.persistence.OrderColumn;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import org.hibernate.search.annotations.Indexed;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.hibernate.search.annotations.FieldBridge;
import org.hibernate.search.annotations.Field;
import de.muenchen.service.BaseEntity;
import de.muenchen.service.PetersPerfectBridge;
import de.muenchen.vaadin.demo.apilib.domain.Past;
import de.muenchen.auditing.MUCAudited;
import javax.persistence.FetchType;

/*
 * This file will be overwritten on every change of the model!
 * This file was automatically generated by GAIA.
 */
/**
 * This class represents a Keeper_.
 * <p>
 * Only oid and reference will be stored in the database.
 * The entity's content will be loaded according to the reference variable.
 * </p>
 */
@Entity
@Indexed
@Table(name = "Keeper")
public class Keeper_ extends BaseEntity {
	
	// ========= //
	// Variables //
	// ========= //
	
	@Column(name="firstName")
	@Field
	@FieldBridge(impl = PetersPerfectBridge.class)
	@NotNull
	@Size(min=2, max=30)
	private String firstName;
	
	
	@Column(name="lastName")
	@Field
	@FieldBridge(impl = PetersPerfectBridge.class)
	@NotNull
	@Size(min=2, max=30)
	private String lastName;
	
	
	@Column(name="employmentDate")
	@Field
	@FieldBridge(impl = PetersPerfectBridge.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@NotNull
	@Past
	private java.time.LocalDate employmentDate;
	
	
	@Column(name="skill")
	@OrderColumn(name="order_index")
	@CollectionTable(name = "Keeper_Skill", joinColumns = { @JoinColumn(name = "keeper_oid")})
	@ElementCollection
	@Enumerated(EnumType.STRING)
	@NotNull
	@Size(min = 1)
	private java.util.List<Features_> skill = new java.util.ArrayList<>();
	
	
	@Column(name="birthday")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@NotNull
	@Past
	private java.time.LocalDate birthday;
	
	
	@Column(name="salary")
	@NotNull
	@Min((long)0.0)
	private long salary;
	
	
	/**
	 * Default Constructor for keeper.
	 */
	public Keeper_() {}
	
	// =================== //
	// Getters and Setters //
	// =================== //
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	
	public java.time.LocalDate getEmploymentDate(){
		return employmentDate;
	}
	
	public void setEmploymentDate(java.time.LocalDate employmentDate){
		this.employmentDate = employmentDate;
	}
	
	
	public java.util.List<Features_> getSkill(){
		return skill;
	}
	
	public void setSkill(java.util.List<Features_> skill){
		this.skill = skill;
	}
	
	
	public java.time.LocalDate getBirthday(){
		return birthday;
	}
	
	public void setBirthday(java.time.LocalDate birthday){
		this.birthday = birthday;
	}
	
	
	public long getSalary(){
		return salary;
	}
	
	public void setSalary(long salary){
		this.salary = salary;
	}
	
	
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (this == other)
			return true;
		if (!(other.getClass() == Keeper_.class))
			return false;
		if (!super.equals(other))
			return false;
		Keeper_ keeper = (Keeper_) other;
		if (getFirstName() != null ? !getFirstName().equals(keeper.getFirstName()) : keeper.getFirstName() != null)
			return false;
		if (getLastName() != null ? !getLastName().equals(keeper.getLastName()) : keeper.getLastName() != null)
			return false;
		if (getEmploymentDate() != keeper.getEmploymentDate())
			return false;
		if (getSkill() != keeper.getSkill())
			return false;
		if (getBirthday() != keeper.getBirthday())
			return false;
		if (getSalary() != keeper.getSalary())
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
		result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
		result = 31 * result + (getEmploymentDate() != null ? getEmploymentDate().hashCode() : 0);
		result = 31 * result + (getSkill() != null ? getSkill().hashCode() : 0);
		result = 31 * result + (getBirthday() != null ? getBirthday().hashCode() : 0);
		result = 31 * result + (int) (getSalary() ^ (getSalary() >>> 32));
		return result;
	}

	/**
	 * Returns a String representation for this keeper.
	 * The form is:
	 * <EntityName>
	 * <attribute1_Type> <attribute1_name>: <attribute1_value>
	 * <attribute2_Type> <attribute2_name>: <attribute2_value>
	 * ...
	 */
	@Override
	public String toString(){
		String s = "keeper";
		s += "\nString firstName: " + getFirstName();
		s += "\nString lastName: " + getLastName();
		s += "\njava.time.LocalDate employmentDate: " + getEmploymentDate();
		s += "\njava.util.List<Features_> skill: " + getSkill();
		s += "\njava.time.LocalDate birthday: " + getBirthday();
		s += "\nlong salary: " + getSalary();
		return s;
	}
}
