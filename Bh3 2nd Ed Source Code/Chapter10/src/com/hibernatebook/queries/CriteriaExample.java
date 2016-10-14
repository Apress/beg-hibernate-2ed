package com.hibernatebook.queries;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class CriteriaExample {
	public void executeSimpleCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		List results = crit.list();
                System.out.println(results.toString());
		displayProductsList(results);
	}

	public void executeEqualsCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.eq("name", "Mouse"));
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeNotEqualsCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.ne("name", "Mouse"));
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeLikePatternCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.like("name", "Mou%"));
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeILikeMatchModeCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.ilike("name", "browser", MatchMode.END));
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeNullCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.isNull("name"));
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeGreaterThanCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.gt("price", new Double(25.0)));
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeAndCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.gt("price", new Double(25.0)));
		crit.add(Restrictions.like("name", "K%"));
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeOrCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		Criterion price = Restrictions.gt("price", new Double(25.0));
		Criterion name = Restrictions.like("name", "Mou%");
		LogicalExpression orExp = Restrictions.or(price, name);
		crit.add(orExp);
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeAndOrCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		Criterion price = Restrictions.gt("price", new Double(25.0));
		Criterion name = Restrictions.like("name", "Mou%");
		LogicalExpression orExp = Restrictions.or(price, name);
		crit.add(orExp);
		crit.add(Restrictions.ilike("description", "blocks%"));
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeDisjunctionCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		Criterion price = Restrictions.gt("price", new Double(25.0));
		Criterion name = Restrictions.like("name", "Mou%");
		Criterion desc = Restrictions.ilike("description", "blocks%");
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(price);
		disjunction.add(name);
		disjunction.add(desc);
		crit.add(disjunction);
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeSQLCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.sqlRestriction("{alias}.name like 'Mou%'"));
		List results = crit.list();
		displayProductsList(results);
	}

	public void executePagingCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.setFirstResult(1);
		crit.setMaxResults(2);
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeUniqueResultCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.setMaxResults(1);
		Product product = (Product) crit.uniqueResult();
		// test for null here if needed

		List results = new ArrayList();
		results.add(product);
		displayProductsList(results);
	}

	public void executeUniqueResultExceptionCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		Product product = (Product) crit.uniqueResult();
		// test for null here if needed

		List results = new ArrayList();
		results.add(product);
		displayProductsList(results);
	}

	public void executeOrderCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.gt("price", new Double(25.0)));
		crit.addOrder(Order.desc("price"));
		List results = crit.list();
		displayProductsList(results);
	}

	public void executeOneToManyAssociationsCriteria(Session session) {
		Criteria crit = session.createCriteria(Supplier.class);
		Criteria prdCrit = crit.createCriteria("products");
		prdCrit.add(Restrictions.gt("price", new Double(25.0)));
		List results = crit.list();
		displaySupplierList(results);
	}

	public void executeAssociationsSortingCriteria(Session session) {
		Criteria crit = session.createCriteria(Supplier.class);
		crit.addOrder(Order.desc("name"));
		Criteria prdCrit = crit.createCriteria("products");
		prdCrit.add(Restrictions.gt("price", new Double(25.0)));
		// prdCrit.addOrder(Order.desc("price"));
		List results = prdCrit.list();
		displaySupplierList(results);
	}

	public void executeManyToOneAssociationsCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		Criteria suppCrit = crit.createCriteria("supplier");
		suppCrit.add(Restrictions.eq("name", "MegaInc"));
		List results = crit.list();

		displayProductsList(results);
	}

	public void executeQBECriteria(Session session) {
		Criteria crit = session.createCriteria(Supplier.class);
		Supplier supplier = new Supplier();
		supplier.setName("MegaInc");
		crit.add(Example.create(supplier));
		List results = crit.list();

		displaySupplierList(results);
	}

	public void executeNotNullOrZeroQBECriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		Product exampleProduct = new Product();
		exampleProduct.setName("Mouse");
		Example example = Example.create(exampleProduct);
		example.excludeZeroes();
		crit.add(example);
		List results = crit.list();

		displayProductsList(results);
	}

	public void executeQBEAdvancedCriteria(Session session) {
		Criteria prdCrit = session.createCriteria(Product.class);
		Product product = new Product();
		product.setName("M%");
		Example prdExample = Example.create(product);
		prdExample.excludeProperty("price");
		prdExample.enableLike();
		Criteria suppCrit = prdCrit.createCriteria("supplier");
		Supplier supplier = new Supplier();
		supplier.setName("SuperCorp");
		suppCrit.add(Example.create(supplier));
		prdCrit.add(prdExample);
		List results = prdCrit.list();

		displayProductsList(results);
	}

	public void executeRowCountCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.setProjection(Projections.rowCount());
		List results = crit.list();
		displayObjectList(results);
	}

	public void executeAggregatesCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.max("price"));
		projList.add(Projections.min("price"));
		projList.add(Projections.avg("price"));
		projList.add(Projections.countDistinct("description"));
		crit.setProjection(projList);
		List results = crit.list();
		displayObjectsList(results);
	}

	public void executeProjectionCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.property("name"));
		projList.add(Projections.property("description"));
		crit.setProjection(projList);
		List results = crit.list();
		displayObjectsList(results);
	}

	public void executeGroupByCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.groupProperty("name"));
		projList.add(Projections.groupProperty("price"));
		crit.setProjection(projList);
		List results = crit.list();
		displayObjectsList(results);
	}

	public void executeDistinctCriteria(Session session) {
		Criteria crit = session.createCriteria(Product.class);
		crit.add(Restrictions.gt("price", new Double(25.0)));
		crit.add(Restrictions.like("name", "K%"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List results = crit.list();
		displayProductsList(results);
	}

	public void populate(Session session) {

		Supplier superCorp = new Supplier();
		superCorp.setName("SuperCorp");
		session.save(superCorp);

		Supplier megaInc = new Supplier();
		megaInc.setName("MegaInc");
		session.save(megaInc);

		Product mouse = new Product("Mouse", "Optical Wheel Mouse", 20.0);
		mouse.setSupplier(superCorp);
		superCorp.getProducts().add(mouse);

		Product mouse2 = new Product("Mouse", "One Button Mouse", 22.0);
		mouse2.setSupplier(superCorp);
		superCorp.getProducts().add(mouse2);

		Product keyboard = new Product("Keyboard", "101 Keys", 30.0);
		keyboard.setSupplier(megaInc);
		megaInc.getProducts().add(keyboard);

		Software webBrowser = new Software("Web Browser", "Blocks Pop-ups",
				75.0, "2.0");
		webBrowser.setSupplier(superCorp);
		superCorp.getProducts().add(webBrowser);

		Software email = new Software("Email", "Blocks spam", 49.99,
				"4.1 RMX Edition");
		email.setSupplier(megaInc);
		megaInc.getProducts().add(email);

	}

	public void displayObjectList(List list) {
		Iterator iter = list.iterator();
		if (!iter.hasNext()) {
			System.out.println("No objects to display.");
			return;
		}
		while (iter.hasNext()) {
			Object obj = iter.next();

			System.out.println(obj);
		}
	}

	public void displayObjectsList(List list) {
		Iterator iter = list.iterator();
		if (!iter.hasNext()) {
			System.out.println("No objects to display.");
			return;
		}
		while (iter.hasNext()) {
			System.out.println("New object");
			Object[] obj = (Object[]) iter.next();
			for (int i = 0; i < obj.length; i++) {
				System.out.println(obj[i]);
			}

		}
	}

	public void displayProductsList(List list) {
		Iterator iter = list.iterator();
		if (!iter.hasNext()) {
			System.out.println("No products to display.");
			return;
		}
		while (iter.hasNext()) {
			Product product = (Product) iter.next();
			String msg = product.getSupplier().getName() + "\t";
			msg += product.getName() + "\t";
			msg += product.getPrice() + "\t";
			msg += product.getDescription();
			System.out.println(msg);
		}
	}

	public void displaySoftwareList(List list) {
		Iterator iter = list.iterator();
		if (!iter.hasNext()) {
			System.out.println("No software to display.");
			return;
		}
		while (iter.hasNext()) {
			Software software = (Software) iter.next();
			String msg = software.getSupplier().getName() + "\t";
			msg += software.getName() + "\t";
			msg += software.getPrice() + "\t";
			msg += software.getDescription() + "\t";
			msg += software.getVersion();
			System.out.println(msg);
		}
	}

	public void displaySupplierList(List list) {
		Iterator iter = list.iterator();
		if (!iter.hasNext()) {
			System.out.println("No suppliers to display.");
			return;
		}
		while (iter.hasNext()) {
			Supplier supplier = (Supplier) iter.next();
			String msg = supplier.getName();
			System.out.println(msg);
		}
	}

	public static void main(String args[]) throws Exception {
            if (args.length > 1) {
			System.out.println("One parameter expected but " + args.length
					+ " received.");
			return;
		}
            
		CriteriaExample example = new CriteriaExample();


		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

		Session session = factory.openSession();
		session.beginTransaction();

                String action = args[0];
		if( action.equalsIgnoreCase(POPULATE) ) {
			example.populate(session);
			session.getTransaction().commit();
			session.beginTransaction();
                } else {
			action = "execute" + action;

			Method method = CriteriaExample.class.getMethod(action,
					new Class[] { Session.class });
			method.invoke(example, new Object[] { session });
		}


		session.getTransaction().commit();
		session.close();
	}

	private static final String POPULATE = "populate";
}
