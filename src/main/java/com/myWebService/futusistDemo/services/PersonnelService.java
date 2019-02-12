package com.myWebService.futusistDemo.services;

import com.myWebService.futusistDemo.models.Personnel;

import java.util.List;

public interface PersonnelService {

    List<Personnel> getAllPersonnelList();
    // save and personel
    Personnel savePersonnel(Personnel personnel);
    String savePersonnelDetail(Personnel personnel);

    Personnel findById(String id);
    Personnel findById(Integer id);


}
