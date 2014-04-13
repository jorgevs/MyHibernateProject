package com.jvs.hibernate.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import com.jvs.hibernate.entity.User;
import com.jvs.hibernate.service.UserService;
import com.jvs.hibernate.util.AuditInterceptor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:beansTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

	@Autowired
	private UserService userService;

	@Autowired
	private DataSource dataSource;

	@Before
	public void initTest() {
		logger.info("Truncating User table...");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("DELETE FROM USERS");
	}

	@Test
	public void createUserTest() {
		//Sets the testing userId value
		AuditInterceptor.setUserIdForCurrentThread(new Long(9999));

		
		User user = new User("d123", "DidierTest", "SanchezTest");		
		userService.saveUser(user);
		logger.info("Saving user: " + (user.toString()));
		
		
		AuditInterceptor.setUserIdForCurrentThread(new Long(1111));
		user = userService.findByUserName("d123");
		user.setFirstName("xxx");
		userService.saveUser(user);		
		logger.info("Updating user: " + (user.toString()));
		
		
		AuditInterceptor.setUserIdForCurrentThread(new Long(2222));		
		user.setEmail("didier@gmail.com");
		userService.saveUser(user);
		logger.info("Saving user: " + (user.toString()));

		List<User> listUsers = userService.loadAllUsers();
		assertEquals("Total number of users must be 1.", 1, listUsers.size());

	}

}
