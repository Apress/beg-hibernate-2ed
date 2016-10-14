package com.hibernatebook.annotations;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class AnnotationsExample {

    private static SessionFactory factory = new AnnotationConfiguration()
            .configure().buildSessionFactory();

    public static void main(String... args) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            System.out.println("Creating data...");
            createData(session);
            System.out.println("Displaying data...");
            displayData(session);
            System.out.println("Demonstrating named query...");
            namedQuery(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session.isOpen())
                session.close();
        }
    }

    public static void createData(Session session) {

        AuthorAddress austin = new AuthorAddress("Austin, TX", "USA");
        AuthorAddress london = new AuthorAddress("London", "UK");

        Author jeff = new Author("Jeff", austin);
        Author dave = new Author("Dave", london);

        Book book = new Book("Pro Hibernate 3", 200);
        book.setPublicationDate(new Date());

        ComputerBook compBook = new ComputerBook(
                "Building Portals with the Java Portlet API", 350);
        compBook.setSoftwareName("Apache Pluto");

        book.addAuthor(jeff);
        book.addAuthor(dave);

        compBook.addAuthor(jeff);
        compBook.addAuthor(dave);

        Address apress = new Address("Berkeley", "USA");
        Publisher pub = new Publisher("Apress", apress);

        // TODO:
        book.setPublisher(pub);
        compBook.setPublisher(pub);
        pub.getBooks().add(book);
        pub.getBooks().add(compBook);

        session.save(pub);
    }

    @SuppressWarnings("unchecked")
    public static void displayData(Session session) {
        Query pubQuery = session.createQuery("from Publisher");

        // This cast is necessarily unsafe. We therefore suppress
        // unchecked cast (generics) warnings for this method.
        List<Publisher> publishers = (List<Publisher>) pubQuery.list();

        System.out.println("Identified " + publishers.size() + " publishers");
        System.out.println();

        // List all the publishers
        for (Publisher pub : publishers) {
            System.out.println("Publisher: " + pub.getName());

            // List all books from this publisher
            for (Book book : pub.getBooks()) {
                System.out.println("Book: " + book.getTitle());

                // List all the authors of this book
                for (Author author : book.getAuthors()) {
                    System.out.println("Author: " + author.getName());
                }

                // For computer books, display the software
                // associated with the title
                if (book instanceof ComputerBook) {
                    ComputerBook compBook = (ComputerBook) book;
                    System.out.println("Software: "
                            + compBook.getSoftwareName());
                }

                System.out.println();
            }

            System.out.println();
        }
    }

    public static void namedQuery(Session session) {
        Query query = session.getNamedQuery("findAuthorsByName");
        query.setParameter("author", "Dave");
        List booksByDave = query.list();
        System.out.println("There is/are " + booksByDave.size()
                + " author(s) called Dave in the catalog");
    }

   
}