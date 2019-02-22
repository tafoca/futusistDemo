package com.myWebService.futusistDemo.repositories;

import com.myWebService.futusistDemo.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
