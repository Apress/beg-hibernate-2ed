package com.hibernatebook.session.deadlock;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GenerateDeadlock {

   private static SessionFactory factory = new Configuration().configure()
         .buildSessionFactory();

   public static void createUser(String username) throws HibernateException {
      Session session = factory.openSession();
            try {
         session.beginTransaction();

         // Normal usage of the Session here...
         Publisher p = new Publisher(username);
         Subscriber s = new Subscriber(username);
         session.saveOrUpdate(p);
         session.saveOrUpdate(s);

         // Commit the transaction
         session.getTransaction().commit();
      } catch (HibernateException e1) {
         rollback(session);
         throw e1;
      } finally {
         // Close the session
         close(session);
      }
   }

   public static void reset(Session session, int isolation) {
      if (isolation >= 0) {
         try {
            session.connection().setTransactionIsolation(isolation);
         } catch (SQLException e) {
            System.err.println("Could not reset the isolation level: " + e);
         } catch (HibernateException e) {
            System.err.println("Could not reset the isolation level: " + e);
         }
      }
   }

   public static void close(Session session) {
      try {
         session.close();
      } catch (HibernateException e) {
         System.err.println("Could not close the session: " + e);
      }
   }

   public static void rollback(Session session) {
      try {
         Transaction tx = session.getTransaction();
         if (tx.isActive())
            tx.rollback();
      } catch (HibernateException e) {
         System.err.println("Could not rollback the session: " + e);
      }
   }
   public static void main(String[] argv) {

      System.out.println("Creating test user...");
      createUser("test");

      System.out.println("Proceeding to main test...");
      Session s1 = factory.openSession();
      Session s2 = factory.openSession();

      try {
         s1.beginTransaction();
         s2.beginTransaction();

         System.out.println("Update 1");
         Query q1 = s1.createQuery("from Publisher");
         Publisher pub1 = (Publisher) q1.uniqueResult();
         pub1.setUsername("jeff");
         s1.flush();

         System.out.println("Update 2");
         Query q2 = s2.createQuery("from Subscriber");
         Subscriber sub1 = (Subscriber) q2.uniqueResult();
         sub1.setUsername("dave");
         s2.flush();

         System.out.println("Update 3");
         Query q3 = s1.createQuery("from Subscriber");
         Subscriber sub2 = (Subscriber) q3.uniqueResult();
         sub2.setUsername("jeff");
         s1.flush();

         System.out.println("Update 4");
         Query q4 = s2.createQuery("from Publisher");
         Publisher pub2 = (Publisher) q4.uniqueResult();
         pub2.setUsername("dave");
         s2.flush();

         s1.getTransaction().commit();
         s2.getTransaction().commit();

      } catch (RuntimeException e1) {
         e1.printStackTrace();
         // Run the boilerplate to roll back the sessions
         rollback(s1);
         rollback(s2);
         throw e1;
      } finally {
         // Run the boilerplate to close the sessions
                   close(s1);
         close(s2);
      }
   }
}