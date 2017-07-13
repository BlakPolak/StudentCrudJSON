package com.codecool.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String klass;

    public Student(){
    }

    public Student(String id, String first_name, String last_name, String klass){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.klass = klass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getKlass() {
        return klass;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }
}
