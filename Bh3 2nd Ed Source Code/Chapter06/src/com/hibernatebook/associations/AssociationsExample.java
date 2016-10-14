package com.hibernatebook.associations;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class AssociationsExample {

    private static SessionFactory factory = 
        new AnnotationConfiguration().configure().buildSessionFactory();
    
    private static Session session;
    
    public static void main(String... args) {
        openSession();
        beginTransaction();
        
        Email email = new Email("Test Email");
        Message message = new Message("Test Message");
        //email.setMessage(message);
        message.setEmail(email);
        
        save(email,message);
        
        System.out.println("Stored...");        
        System.out.println(email);
        System.out.println(email.getMessage());
        System.out.println(message);
        System.out.println(message.getEmail());
        
        Serializable emailPrimaryKey = session.getIdentifier(email);
        Serializable messagePrimaryKey = session.getIdentifier(message);
        endTransaction();
        
        closeSession();
        openSession();

        beginTransaction();
        
        email = (Email)session.get(Email.class,emailPrimaryKey);
        message = (Message)session.get(Message.class,messagePrimaryKey);

        System.out.println("Retrieved...");
        System.out.println(email);
        System.out.println(email.getMessage());
        System.out.println(message);
        System.out.println(message.getEmail());        
        endTransaction();
        closeSession();
    }
    
    public static void beginTransaction() {
        session.beginTransaction();
    }
    
    public static void endTransaction() {
        session.getTransaction().commit();
    }
    
    public static void openSession() {
        session = factory.openSession();
    }
    
    public static void closeSession() {
        session.close();
    }
    
    public static void save(Object... objects) {
        for(Object obj : objects ) {
            session.saveOrUpdate(obj);
        }
    }
    
    public static void refreshFromHibernate(Object... objects) {
        for(Object obj : objects ) {
            session.refresh(obj);
        }
    }
}  
