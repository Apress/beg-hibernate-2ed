package com.hibernatebook.annotations;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Publisher {

    private int id;
    private String name;
    private Set<Book> books = new HashSet<Book>();
    private Address address;

    // Constructors...

    protected Publisher() {
    }

    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Getters...

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @OneToMany(cascade = ALL, mappedBy = "publisher")
    public Set<Book> getBooks() {
        return books;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Address getAddress() {
        return this.address;
    }

    // Setters...

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
