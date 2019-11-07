package com.codingParkFun.rmsbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Gender;
    private Date birthDate;
    private String address;
    private String email;
    private String nationality;
    private Date enrollmentDate;
    private String zipCode;
    private String city;
    private String state;
    private String country;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    @JsonIgnore
    private School schoolId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id")
    @JsonIgnore
    private Batch batchId;


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {

        this.id = id;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender( String gender ) {
        Gender = gender;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate( Date birthDate ) {
        this.birthDate = birthDate;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }


    public String getNationality() {
        return nationality;
    }

    public void setNationality( String nationality ) {
        this.nationality = nationality;
    }


    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate( Date enrollmentDate ) {
        this.enrollmentDate = enrollmentDate;
    }


    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber( String mobileNumber ) {
        this.mobileNumber = mobileNumber;
    }

    private String mobileNumber;

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }


    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode( String zipCode ) {
        this.zipCode = zipCode;
    }


    public String getState() {
        return state;
    }

    public void setState( String state ) {

        this.state = state;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }
    public String getName() {

        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }



}
