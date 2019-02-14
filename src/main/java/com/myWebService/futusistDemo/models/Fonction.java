package com.myWebService.futusistDemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Fonction {

    @JsonView(Scope.FirstLevel.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @JsonView(Scope.FirstLevel.class)
    String functionName;

    @JsonView(Scope.FirstLevel.class)
    String dateDebut;

    @JsonView(Scope.FirstLevel.class)
    @OneToOne
    Personnel personnel;


    public Fonction() {
    }

    public Fonction(String functionName, String dateDebut) {
        this.functionName = functionName;
        this.dateDebut = dateDebut;
    }


    public Fonction(String functionName, String dateDebut, Personnel personnel) {
        this.functionName = functionName;
        this.dateDebut = dateDebut;
        this.personnel = personnel;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    @Override
    public String toString() {
        return "Fonction{" +
                "id=" + id +
                ", functionName='" + functionName + '\'' +
                ", dateDebut='" + dateDebut + '\'' +
                ", personnel=" + personnel.toString() +
                '}';
    }
}
