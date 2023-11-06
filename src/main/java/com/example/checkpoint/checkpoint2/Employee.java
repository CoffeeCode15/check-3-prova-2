package com.example.checkpoint.checkpoint2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private String id;
    private String fullname;
    private String employementDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmployementDate() {
        return employementDate;
    }

    public void setEmployementDate(String employementDate) {
        this.employementDate = employementDate;
    }
}
