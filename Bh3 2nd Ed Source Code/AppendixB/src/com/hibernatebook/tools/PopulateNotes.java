package com.hibernatebook.tools;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class PopulateNotes {
	public static void main(String... args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		SessionFactory factory = config.configure().buildSessionFactory();
		Session session = factory.openSession();
		
		System.out.println("Creating test notepad...");
		session.beginTransaction();
		
		Notepad notepad = new Notepad("Dave Minter");
		for(int i = 0; i < 100; i++) {
			notepad.addNote("Note number: " + i);
		}
		session.save(notepad);
		session.getTransaction().commit();
		System.out.println("Test notepad created.");

		session.close();
	}
}
