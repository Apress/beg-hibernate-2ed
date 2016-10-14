package com.hibernatebook.queries;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Software extends Product implements Serializable
{
    private String version;

    public Software() {
    }

    public Software(String name, String description,
                    double price, String version)
    {       super(name, description, price);
        this.setVersion(version);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}