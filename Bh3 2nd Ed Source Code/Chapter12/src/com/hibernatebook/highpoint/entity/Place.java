package com.hibernatebook.highpoint.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "geonames")
public class Place {

    @Id
    public int getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(int geonameId) {
        this.geonameId = geonameId;
    }

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name = "country_code", referencedColumnName = "country_code", insertable = false, updatable = false),
        @JoinColumn(name = "admin1_code", referencedColumnName = "admin1_code", insertable = false, updatable = false)
    })
    public Admin1Code getAdmin1Code() {
        return admin1Code;
    }

    public void setAdmin1Code(Admin1Code admin1Code) {
        this.admin1Code = admin1Code;
    }

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name = "country_code", referencedColumnName = "country_code", insertable = false, updatable = false),
        @JoinColumn(name = "admin1_code", referencedColumnName = "admin1_code", insertable = false, updatable = false),
        @JoinColumn(name = "admin2_code", referencedColumnName = "admin2_code", insertable = false, updatable = false)
    })
    public Admin2Code getAdmin2Code() {
        return admin2Code;
    }

    public void setAdmin2Code(Admin2Code admin2Code) {
        this.admin2Code = admin2Code;
    }

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
        @JoinColumn(name = "feature_code", referencedColumnName = "feature_code"),
        @JoinColumn(name = "feature_class", referencedColumnName = "feature_class")
    })
    public FeatureCode getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(FeatureCode featureCode) {
        this.featureCode = featureCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsciiName() {
        return asciiName;
    }

    public void setAsciiName(String asciiName) {
        this.asciiName = asciiName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public int getGtopo30() {
        return gtopo30;
    }

    public void setGtopo30(int gtopo30) {
        this.gtopo30 = gtopo30;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Column(name = "modification_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
    private int geonameId;
    private String name;
    private String asciiName;
    private double latitude;
    private double longitude;
    private long population;
    private int elevation;
    private int gtopo30;
    private String timezone;
    private Date modificationDate;
    private Admin1Code admin1Code;
    private Admin2Code admin2Code;
    private FeatureCode featureCode;
}
