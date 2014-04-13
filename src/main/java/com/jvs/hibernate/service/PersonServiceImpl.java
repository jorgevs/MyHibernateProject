package com.jvs.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jvs.hibernate.dao.PersonDao;
import com.jvs.hibernate.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;
	


	@Override
	@Transactional
	public Person findByPersonName(String firstName, String lastName) {		
		return personDao.findByName(firstName, lastName);
	}	
	
	@Override
	@Transactional
	public List<Person> loadAllPersons() {
		return personDao.findAll(Person.class);
	}
	
	@Override
	@Transactional
	public void savePerson(Person person) {
		personDao.save(person);
	}	
	
	@Override
	@Transactional
	public Person findPersonById(Long id) {
		return personDao.findByID(Person.class, id);
	}	
	
	@Override
	@Transactional
	public void deletePerson(Person person) {
		personDao.delete(person);
	}

}
