package com.hibernatebook.highpoint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@IdClass(com.hibernatebook.highpoint.entity.FeatureCodePK.class)
@Entity
@Table(name = "featurecodes")
public class FeatureCode {

    @Id
    @Column(name = "feature_class")
    public String getFeatureClass() {
        return featureClass;
    }

    public void setFeatureClass(String featureClass) {
        this.featureClass = featureClass;
    }

    @Id
    @Column(name = "feature_code")
    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private String featureClass;
    private String featureCode;
    private String name;
    private String description;
}
