package com.hibernatebook.annotations;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sample {
    @Id
    public Integer id;
    public String name;
}
