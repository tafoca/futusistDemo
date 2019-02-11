package com.myWebService.futusistDemo.repositories;

import com.myWebService.futusistDemo.models.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Personnelrepository extends JpaRepository<Personnel,Integer> {

   // List<Personnel> findPersonnels();
}
