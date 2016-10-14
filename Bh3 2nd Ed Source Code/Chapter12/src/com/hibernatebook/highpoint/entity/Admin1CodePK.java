package com.hibernatebook.highpoint.entity;

import java.io.Serializable;

public class Admin1CodePK implements Serializable {

    public Admin1CodePK() {
    }
    private String countryCode;
    private String admin1Code;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Admin1CodePK other = (Admin1CodePK) obj;
        if ((this.countryCode == null) ? (other.countryCode != null) : !this.countryCode.equals(other.countryCode)) {
            return false;
        }
        if ((this.admin1Code == null) ? (other.admin1Code != null) : !this.admin1Code.equals(other.admin1Code)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.countryCode != null ? this.countryCode.hashCode() : 0);
        return hash;
    }
}
