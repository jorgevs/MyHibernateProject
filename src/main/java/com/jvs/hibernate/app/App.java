package com.jvs.hibernate.app;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jvs.hibernate.entity.Customer;
import com.jvs.hibernate.entity.Order;
import com.jvs.hibernate.util.AuditInterceptor;
import com.jvs.hibernate.util.HibernateUtil;

public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		AuditInterceptor interceptor = new AuditInterceptor();	
		interceptor.setUserIdForCurrentThread(999999L);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession(interceptor);
		session.beginTransaction();

		Customer customer = new Customer();
		customer.setName("Jorge Vazquez");
		session.save(customer);

		Order order1 = new Order(new Date(), "CREDIT", "PAID");
		Order order2 = new Order(new Date(), "CASH", "NOT_PAID");

		order1.setCustomer(customer);
		order2.setCustomer(customer);

		session.save(order1);
		session.save(order2);

		session.getTransaction().commit();
		session.close();

	}

}
