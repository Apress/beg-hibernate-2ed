package com.hibernatebook.associations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class CascadeExample {
    private static SessionFactory factory = 
        new AnnotationConfiguration().configure().buildSessionFactory();
    
    public static void main(String... args) {
        Session session = factory.openSession();
        session.beginTransaction();

        Email email = new Email("Email title");
        Message message = new Message("Message content");
        email.setMessage(message);
        message.setEmail(email);
        
        session.save(email);

        session.getTransaction().commit();
        session.close();

	Integer emailId = email.getId();
        
        session = factory.openSession();
        session.beginTransaction();
        
        email = (Email)session.get(Email.class,emailId);
        System.out.println("Email message: " + email.getMessage());

        session.getTransaction().commit();
        session.close();
    }
}
