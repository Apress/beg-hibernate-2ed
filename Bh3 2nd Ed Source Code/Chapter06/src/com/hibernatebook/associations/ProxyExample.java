package com.hibernatebook.associations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ProxyExample {
    private static SessionFactory factory = 
        new AnnotationConfiguration().configure().buildSessionFactory();
    
    public static void main(String... args) {
        
        Session session = factory.openSession();
        session.beginTransaction();

        Email email = new Email("Email title");
        Message message = new Message("Message content");
        email.setMessage(message);
        message.setEmail(email);
        
        System.out.println("Before: ");
        System.out.println(email.getMessage().getClass().getName());
        session.save(email);
        session.save(message);

        Integer emailId = (Integer)session.getIdentifier(email);
        
        session.getTransaction().commit();
        session.close();
        
        session = factory.openSession();
        session.beginTransaction();
        
        email = (Email)session.get(Email.class,emailId);

        session.getTransaction().commit();
        session.close();

        System.out.println();
        System.out.println("After: ");
        System.out.println(email.getMessage().getClass().getName());
    }
}
