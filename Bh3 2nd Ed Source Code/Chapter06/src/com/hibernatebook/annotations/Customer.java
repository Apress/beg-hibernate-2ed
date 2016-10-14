package com.hibernatebook.annotations;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER")
@SecondaryTable(name="CUSTOMER_DETAILS")
public class Customer {

    @Id
    public int id;    

    public String name;
    
    @Column(table="CUSTOMER_DETAILS")
    public String address;
}
