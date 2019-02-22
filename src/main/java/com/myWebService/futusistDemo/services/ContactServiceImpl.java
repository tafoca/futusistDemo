package com.myWebService.futusistDemo.services;

import com.myWebService.futusistDemo.models.Contact;
import com.myWebService.futusistDemo.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
@Repository
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Override
    public List<Contact> findAllContact() {
        return contactRepository.findAll();
    }

    @Override
    public Contact saveContact(Contact c) {
        return contactRepository.save(c);
    }

    @Override
    public String saveContactState(Contact c) {

        if (saveContact(c) != null ) return "success"; else return "echec";
    }

    @Override
    public Contact findBYId(Integer id) {
        return contactRepository.getOne(id);
    }
}
