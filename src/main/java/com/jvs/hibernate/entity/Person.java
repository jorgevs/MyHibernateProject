package com.jvs.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSONS")
public class Person extends BaseEntityImpl {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PERSON_ID")
	private long PersonId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	public Person(){
		super();
	}
	
	public Person(String firstName, String lastName){
		this.firstName = firstName; 
		this.lastName = lastName;
	}
	
	public long getPersonId() {
		return PersonId;
	}
	public void setPersonId(long personId) {
		PersonId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Person [PersonId=" + PersonId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
