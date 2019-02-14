package com.myWebService.futusistDemo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Collection;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "personnel")
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Scope.FirstLevel.class)
    private Integer id;
    @JsonView(Scope.FirstLevel.class)
    private  String name;
    @JsonView(Scope.FirstLevel.class)
    private  Integer salary;
    @JsonView(Scope.FirstLevel.class)
    private String departement;

    @JsonIgnore
    @OneToMany
    private Collection<Contact> contacts ;


    public Personnel(String name, Integer salary, String departement) {
        this.name = name;
        this.salary = salary;
        this.departement = departement;
    }

    public Personnel(Integer id, String name, Integer salary, String departement) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", departement='" + departement + '\'' +
                '}';
    }
}
