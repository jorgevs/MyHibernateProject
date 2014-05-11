package com.jvs.hibernate.dao;

import com.jvs.hibernate.entity.Person;

public interface PersonDao extends BaseDao<Person, Long> {

	public Person findByName(String firstName, String lastName);

}
