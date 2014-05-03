package com.jvs.hibernate.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jvs.hibernate.entity.Person;
import com.jvs.hibernate.entity.User;
import com.jvs.hibernate.service.PersonService;
import com.jvs.hibernate.service.UserService;

public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		PersonService personService = (PersonService)context.getBean("personService");
		UserService userService = (UserService)context.getBean("userService");
		
		//Creates a Person object to persist it. 
		Person person = new Person("Jorge", "Vazquez");
		personService.savePerson(person);
		logger.info("person created...");
		
		List<Person> listPersons = personService.loadAllPersons();
		for (Person p : listPersons) {
			logger.info("Person: " + p.toString());
		}
		
		
		//Creates a Person object to persist it. 
		User user = new User("Jorge", "Eduardo", "Vazquez");
		userService.saveUser(user);
		logger.info("user created...");
						
		
		
		((ClassPathXmlApplicationContext)context).close();
	}
	
}
