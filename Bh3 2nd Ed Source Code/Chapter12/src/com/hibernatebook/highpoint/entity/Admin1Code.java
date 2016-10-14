package com.hibernatebook.highpoint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@IdClass(com.hibernatebook.highpoint.entity.Admin1CodePK.class)
@Entity
@Table(name = "Admin1Codes")
public class Admin1Code {

    @Id
    @Column(name = "country_code")
    private String countryCode;
    @Id
    @Column(name = "admin1_code")
    private String admin1Code;
    private String name;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAdmin1Code() {
        return admin1Code;
    }

    public void setAdmin1Code(String admin1Code) {
        this.admin1Code = admin1Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
