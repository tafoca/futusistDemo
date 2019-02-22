package com.myWebService.futusistDemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Scope.FirstLevel.class)
    private Integer id_;

    @JsonView(Scope.FirstLevel.class)
    private String type;


    @JsonView(Scope.FirstLevel.class)
    private String value;

    @JsonView(Scope.FirstLevel.class)
    private Boolean isNotificationContact;

    public Contact() {
        this.isNotificationContact =false;
    }

    public Contact(String type, String value, Boolean isNotificationContact) {
        this.type = type;
        this.value = value;
        this.isNotificationContact = isNotificationContact;
    }

    public Integer getId_() {
        return id_;
    }

    public void setId_(Integer id_) {
        this.id_ = id_;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getNotificationContact() {
        return isNotificationContact;
    }

    public void setNotificationContact(Boolean notificationContact) {
        isNotificationContact = notificationContact;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id_=" + id_ +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", isNotificationContact=" + isNotificationContact +
                '}';
    }
}
