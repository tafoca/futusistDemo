package com.myWebService.futusistDemo.services;

import com.myWebService.futusistDemo.models.Contact;

import java.util.List;

public interface ContactService {


    List<Contact> findAllContact();

    Contact saveContact(Contact function);

    String saveContactState(Contact function);

    Contact findBYId(Integer id);
}
