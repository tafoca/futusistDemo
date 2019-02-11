package com.myWebService.futusistDemo.services;

import com.myWebService.futusistDemo.models.Personnel;
import com.myWebService.futusistDemo.repositories.Personnelrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
@Repository
public class PersonnelServiceImpl implements PersonnelService {

    @Autowired
    Personnelrepository personnelrepository;

    @Override
    public List<Personnel> getAllPersonnelList() {
        return personnelrepository.findAll();
    }

    @Override
    public Personnel savePersonnel(Personnel personnel) {
        return personnelrepository.save(personnel);
    }

    @Override
    public String savePersonnelDetail(Personnel personnel) {
        Personnel p = this.savePersonnel(personnel);
        if (p != null) return "success";
        return "echec";
    }


}
