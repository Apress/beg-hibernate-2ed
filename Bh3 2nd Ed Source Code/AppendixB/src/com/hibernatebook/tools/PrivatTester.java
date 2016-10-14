package com.hibernatebook.tools;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class PrivatTester {
	public static void main(String[] args) {

		AnnotationConfiguration config = new AnnotationConfiguration();
		SessionFactory factory = config.configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();
		session.save(new Privat("MESSAGE"));
		session.getTransaction().commit();
		
		session.close();
		
		session = factory.openSession();
		session.beginTransaction();
		List list = session.createQuery("from Privat").list();
		Iterator i = list.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		session.getTransaction().commit();
		session.close();
	}
}
