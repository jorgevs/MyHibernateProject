package com.jvs.hibernate.service;

import java.util.List;

import com.jvs.hibernate.entity.Person;

public interface PersonService {
	
    public Person findByPersonName(String firstName, String lastName);
    
    public List<Person> loadAllPersons();
 
    public void savePerson(Person person);
 
    public Person findPersonById(Long id);
 
    public void deletePerson(Person person);	
	
}
