package de.neuefische.firstspringbootproject.students;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Student {

    private final String id = UUID.randomUUID().toString();
    private String lastname;
    private String firstname;

    public Student(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFullname() {
        return firstname + " " + lastname;
    }

}