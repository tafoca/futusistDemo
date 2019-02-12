package com.myWebService.futusistDemo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Fonction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String functionName;

    String dateDebut;

    @OneToOne
    Personnel personnel;

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
}
