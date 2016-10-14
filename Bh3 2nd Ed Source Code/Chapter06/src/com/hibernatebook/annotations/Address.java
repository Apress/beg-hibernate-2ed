package com.hibernatebook.annotations;

import javax.persistence.*;

@Entity
public class Address {
    private int id;
    private String city;
    private String country;

    // Constructors...

    protected Address() {
    }
    
    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }
    
    // Getters...

    @Id
    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
    
    // Setters...

    public void setId(int id) {
        this.id = id;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
