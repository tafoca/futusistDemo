package com.myWebService.futusistDemo.models;

import javax.persistence.*;

@Entity
@Table(name = "personnel")
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private  String name;

    private  Integer salary;

    private String departement;

    public Personnel(String name, Integer salary, String departement) {
        this.name = name;
        this.salary = salary;
        this.departement = departement;
    }

    public Personnel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

}
