package com.myWebService.futusistDemo.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.myWebService.futusistDemo.models.Contact;
import com.myWebService.futusistDemo.models.Personnel;
import com.myWebService.futusistDemo.models.Scope;
import com.myWebService.futusistDemo.services.ContactService;
import com.myWebService.futusistDemo.services.PersonnelService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ContactEndpoint {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/add-contact",method = RequestMethod.POST)
    public String saveContact(@RequestBody Contact contact){

        System.out.println(contact.toString());

        return  contactService.saveContactState(contact);
    }

    @RequestMapping(value = "/all-contacts",method = RequestMethod.GET)
    public ResponseEntity<List<Contact>> getAllContact(){
        List<Contact> contacts = contactService.findAllContact();
        return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
    }

    @JsonView(Scope.FirstLevel.class)
    @RequestMapping(value = "/contacts/show/{id}",method = RequestMethod.GET)
    public ResponseEntity<Contact> getContact(@PathVariable Integer id){

        Contact contact = contactService.findBYId(id);

        System.out.println("----->->>"+id);
        System.out.println("----->>>"+contact.toString());

        return new ResponseEntity<Contact>(contact, HttpStatus.OK);

    }
}
