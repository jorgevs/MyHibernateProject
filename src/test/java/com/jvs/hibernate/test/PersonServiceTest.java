package com.jvs.hibernate.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jvs.hibernate.entity.Person;
import com.jvs.hibernate.service.PersonService;

@ContextConfiguration("classpath:beansTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(PersonServiceTest.class);
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private DataSource dataSource;
	
	
	@Before
	public void initTest(){
		logger.info("Truncating Person table...");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("DELETE FROM PERSONS");
	}
	
	@Test
	public void createPersonTest(){
		Person person = new Person("DidierTest", "SanchezTest");
		personService.savePerson(person);
		
		
		List<Person> listPersons = personService.loadAllPersons();
		assertEquals("Total number of persons must be 1.", 1, listPersons.size());
		
	}
	
}
