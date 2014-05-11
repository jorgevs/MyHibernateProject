package com.jvs.hibernate.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jvs.hibernate.entity.Person;

@Repository("personDao")
public class PersonDaoImpl extends BaseDaoImpl<Person, Long> implements PersonDao {
	
	public PersonDaoImpl() {
		super(Person.class);
	}
	
	public Person findByName(String firstName, String lastName) {        
        Query query = session().createQuery("FROM Person P WHERE P.firstName =:firstName AND P.lastName =:lastName");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return findOne(query);        
    }
	
}
