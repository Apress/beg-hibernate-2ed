package com.hibernatebook.highpoint.entity;

import java.io.Serializable;

public class Admin2CodePK implements Serializable {

    public Admin2CodePK() {
    }
    private String countryCode;
    private String admin1Code;
    private String admin2Code;

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

    public String getAdmin2Code() {
        return admin2Code;
    }

    public void setAdmin2Code(String admin2Code) {
        this.admin2Code = admin2Code;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Admin2CodePK other = (Admin2CodePK) obj;
        if ((this.countryCode == null) ? (other.countryCode != null) : !this.countryCode.equals(other.countryCode)) {
            return false;
        }
        if ((this.admin1Code == null) ? (other.admin1Code != null) : !this.admin1Code.equals(other.admin1Code)) {
            return false;
        }
        if ((this.admin2Code == null) ? (other.admin2Code != null) : !this.admin2Code.equals(other.admin2Code)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.countryCode != null ? this.countryCode.hashCode() : 0);
        hash = 67 * hash + (this.admin1Code != null ? this.admin1Code.hashCode() : 0);
        hash = 67 * hash + (this.admin2Code != null ? this.admin2Code.hashCode() : 0);
        return hash;
    }
}
