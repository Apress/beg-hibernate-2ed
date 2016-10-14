package sample;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import sample.entity.Message;

public class ListMessages {
   public static void main(String[] args)
   {
      SessionFactory factory =
         new AnnotationConfiguration().configure().buildSessionFactory();
      Session session = factory.openSession();

      List messages = session.createQuery("from Message").list();
      System.out.println("Found " + messages.size() + " message(s):");

      Iterator i = messages.iterator();
      while(i.hasNext()) {
         Message msg = (Message)i.next();
         System.out.println(msg.getMessageText());
      }

      session.close();
   }
}