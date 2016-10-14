package com.hibernatebook.annotations;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.InheritanceType.JOINED;

import java.util.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = JOINED)
public class Book {

    private String title;
    private Publisher publisher;
    private Set<Author> authors = new HashSet<Author>();
    private int pages;
    private int id;
    protected Date publicationDate;

    // Constructors...

    protected Book() {
    }

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    // Getters...

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @Column(name = "working_title", length = 200, nullable = false)
    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    @Transient
    public Date getPublicationDate() {
        return publicationDate;
    }

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    public Publisher getPublisher() {
        return publisher;
    }

    @ManyToMany(cascade = ALL)
    public Set<Author> getAuthors() {
        return authors;
    }

    // Setters...

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    // Helpers...
    public void addAuthor(Author author) {
        authors.add(author);
    }
}
