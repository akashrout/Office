package com.akash.DemoHib;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Alien alien = new Alien();
		alien.setAid(105);
		alien.setAname("rag");
		alien.setColor("black");
		
		//Alien alien = new Alien();
//		alien.setAid(102);
//		alien.setAname("Abhi");
//		alien.setColor("Green");
		
//		alien.setAid(103);
//		alien.setAname("Neeraj");
//		alien.setColor("Blue");

		Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);
		
		ServiceRegistry reg  = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		
		
		SessionFactory factory = conf.buildSessionFactory(reg);
		Session session = factory.openSession(); 
		
		org.hibernate.Transaction tx = session.beginTransaction() ;
		
		session.save(alien);
		tx.commit(); 
	}
}
