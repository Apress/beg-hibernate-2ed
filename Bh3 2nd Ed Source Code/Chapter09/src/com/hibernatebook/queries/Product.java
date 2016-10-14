package com.hibernatebook.queries;

import java.io.Serializable;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;

@Entity
@NamedQuery(name="com.hibernatebook.queries.Product.HQLpricing",
query=" select product.price from Product product where product.price > 25.0")
@NamedNativeQuery(name="com.hibernatebook.queries.Product.SQLpricing",
query="select product.price from Product as product where product.price > 25.0",
        resultSetMapping="SQLPricingMapping")
@SqlResultSetMapping(name="SQLPricingMapping", columns=@ColumnResult(name="price"))
@Inheritance(
    strategy=InheritanceType.JOINED
)

public class Product implements Serializable
{
    private int id;
    private Supplier supplier;

    private String name;
    private String description;
    private double price;

    public Product() {
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {       return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}