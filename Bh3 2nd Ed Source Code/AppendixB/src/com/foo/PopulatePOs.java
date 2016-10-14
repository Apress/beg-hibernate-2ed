package com.foo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Expression;

public class PopulatePOs {
	public static void main(String[] args) {
		AnnotationConfiguration config = new AnnotationConfiguration();
		SessionFactory factory = config.configure().buildSessionFactory();
		Session session = factory.openSession();
		
		session.beginTransaction();

		PurchaseOrder po1 = new PurchaseOrder();
		po1.setDescription("The Purchase Order");
		Office office1 = new Office();
		office1.setDescription("The office");
		office1.setSuffix("foo");
		po1.setOffice(office1);
		
		session.save(office1);
		session.save(po1);

		PurchaseOrder po = new PurchaseOrder();
		po.setDescription("The other Purchase Order");
		Office office = new Office();
		office.setDescription("The other office");
		office.setSuffix("bar");
		po.setOffice(office);
		
		session.save(office);
		session.save(po);

		session.getTransaction().commit();
		session.close();
		
		System.out.println("Saved the example objects");
		
		session = factory.openSession();

		session.beginTransaction();
		Criteria crit1 = session.createCriteria(PurchaseOrder.class);
		Criteria crit2 = crit1.createCriteria("office","offices");
		Criteria crit3 = crit2.add(Expression.eq("suffix","foo"));
		List list = crit3.list();
		
		System.out.println("Exercising criteria");
		for(Object o : list) {
			System.out.println(o);
		}
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();		
	}
}
