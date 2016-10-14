package com.hibernatebook.highpoint.entity;

import java.io.Serializable;

public class FeatureCodePK implements Serializable {

    public String getFeatureClass() {
        return featureClass;
    }

    public void setFeatureClass(String featureClass) {
        this.featureClass = featureClass;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }
    private String featureClass;
    private String featureCode;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FeatureCodePK other = (FeatureCodePK) obj;
        if ((this.featureClass == null) ? (other.featureClass != null) : !this.featureClass.equals(other.featureClass)) {
            return false;
        }
        if ((this.featureCode == null) ? (other.featureCode != null) : !this.featureCode.equals(other.featureCode)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.featureClass != null ? this.featureClass.hashCode() : 0);
        hash = 53 * hash + (this.featureCode != null ? this.featureCode.hashCode() : 0);
        return hash;
    }
}
