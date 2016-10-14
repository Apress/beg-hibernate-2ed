package com.hibernatebook.annotations;

import javax.persistence.*;

@Embeddable
public class AuthorAddress {
    private String address;
    private String country;
    
    // Constructors...
    
    protected AuthorAddress() {
    }
    
    public AuthorAddress(String address, String country) {
        this.address = address;
        this.country = country;
    }
    
    // Getters...

    public String getAddress() {
        return address;
    }
    
    public String getCountry() {
        return country;
    }
    
    // Setters...

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
}
