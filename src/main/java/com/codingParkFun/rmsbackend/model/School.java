package com.codingParkFun.rmsbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String address;

    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAddress( String address ) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }
    public void setId( Long id ) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
