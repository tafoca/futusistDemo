package com.myWebService.futusistDemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.annotations.Expose;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Realisation {
    //@Expose (serialize = true, deserialize = true)
    @JsonView(Scope.FirstLevel.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

   // @Expose (serialize = true, deserialize = true)
    @JsonView(Scope.FirstLevel.class)
    String realisationName;

   // @Expose (serialize = true, deserialize = true)
    @JsonView(Scope.FirstLevel.class)
    String description;

    //@Expose (serialize = true, deserialize = true)
    @JsonView(Scope.FirstLevel.class)
    private String beginRealisation;

    //@Expose (serialize = true, deserialize = true)
    @JsonView(Scope.FirstLevel.class)
    private String endRealisation;

   // @Expose(deserialize = false)
    @JsonView(Scope.FirstLevel.class)
    @ManyToOne(targetEntity = Fonction.class)
    private Fonction function;


    public Realisation() {

    }

    public Realisation(String realisationName, String description, String beginRealisation, String endRealisation) {
        this.realisationName = realisationName;
        this.description = description;
        this.beginRealisation = beginRealisation;
        this.endRealisation = endRealisation;
    }

    public String getRealisationName() {
        return realisationName;
    }

    public void setRealisationName(String realisationName) {
        this.realisationName = realisationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeginRealisation() {
        return beginRealisation;
    }

    public void setBeginRealisation(String beginRealisation) {
        this.beginRealisation = beginRealisation;
    }

    public String getEndRealisation() {
        return endRealisation;
    }

    public void setEndRealisation(String endRealisation) {
        this.endRealisation = endRealisation;
    }

    public Fonction getFunction() {
        return function;
    }

    public void setFunction(Fonction function) {
        this.function = function;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Realisation{" +
                "realisationName='" + realisationName + '\'' +
                ", description='" + description + '\'' +
                ", beginRealisation=" + beginRealisation +
                ", endRealisation=" + endRealisation +
                //", function=" + function +
                '}';

    }
}
