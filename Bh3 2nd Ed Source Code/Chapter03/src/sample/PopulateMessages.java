package sample;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import sample.entity.Message;

public class PopulateMessages {
   public static void main(String[] args) {
         SessionFactory factory =
            new AnnotationConfiguration().configure().buildSessionFactory();
         Session session = factory.openSession();
         session.beginTransaction();

         Message m1 = new Message(
            "Hibernated a message on " + new Date());
         session.save(m1);
         session.getTransaction().commit();
         session.close();
   }
}