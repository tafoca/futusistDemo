package com.myWebService.futusistDemo.controllers;

import com.myWebService.futusistDemo.models.Personnel;
import com.myWebService.futusistDemo.services.PersonnelService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class PersonnelEndpoint {

    @Autowired
    private PersonnelService personnelService;

    @RequestMapping(value = "/add-personnel",method = RequestMethod.POST)
    public String savePersonnel(@RequestBody JSONObject personnel){

        System.out.println(personnel.toJSONString());

        Personnel personnel1 = new Personnel(personnel.get("name").toString(),
                Integer.parseInt(personnel.get("salary").toString()),
                personnel.get("departement").toString());

        //return new ResponseEntity<Personnel>(personnel1, HttpStatus.CREATED);
        return  personnelService.savePersonnelDetail(personnel1);
    }

    @RequestMapping(value = "/all-personnels",method = RequestMethod.GET)
    public ResponseEntity<List<Personnel>> getAllPersonnel(){
        List<Personnel> personnels = personnelService.getAllPersonnelList();
        return new ResponseEntity<List<Personnel>>(personnels, HttpStatus.OK);
    }
}
