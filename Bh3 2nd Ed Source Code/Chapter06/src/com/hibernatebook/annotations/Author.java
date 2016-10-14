package com.hibernatebook.annotations;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@NamedQuery(
  name="findAuthorsByName",
  query="from Author where name = :author"
)
public class Author {
    
    private int id;
    private String name;
    private Set<Book> books = new HashSet<Book>();
    private AuthorAddress address;

    // Constructors...
    
    protected Author() {
    }

    public Author(String name, AuthorAddress address) {
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

    @ManyToMany(mappedBy = "authors")
    public Set<Book> getBooks() {
        return books;
    }

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="address",column=@Column(name="ADDR")),
        @AttributeOverride(name="country",column=@Column(name="NATION"))
    })
    public AuthorAddress getAddress() {
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
    
    public void setAddress(AuthorAddress address) {
        this.address = address;
    }
}
