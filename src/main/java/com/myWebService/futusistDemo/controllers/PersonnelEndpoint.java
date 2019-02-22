package com.myWebService.futusistDemo.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.gson.Gson;
import com.myWebService.futusistDemo.models.Fonction;
import com.myWebService.futusistDemo.models.Personnel;
import com.myWebService.futusistDemo.models.Scope;
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
public class PersonnelEndpoint {

    @Autowired
    private PersonnelService personnelService;

    @RequestMapping(value = "/add-personnel",method = RequestMethod.POST)
    public String savePersonnel(@RequestBody JSONObject personnel){

        System.out.println(personnel.toJSONString());


        Gson gson =new Gson();
        Personnel userIdentifier = gson.fromJson(personnel.toJSONString().toString(), Personnel.class);
        System.out.println("----->>>>>>>>>>"+ userIdentifier.toString() + ">><<<<<<<<<<<<<<<<<<<<<<<--------------");


        /*Personnel personnel1 = new Personnel(personnel.get("name").toString(),
                Integer.parseInt(personnel.get("salary").toString()),
                personnel.get("departement").toString());*/

        //return new ResponseEntity<Personnel>(personnel1, HttpStatus.CREATED);
        return  personnelService.savePersonnelDetail(userIdentifier);
    }

    @RequestMapping(value = "/all-personnels",method = RequestMethod.GET)
    public ResponseEntity<List<Personnel>> getAllPersonnel(){
        List<Personnel> personnels = personnelService.getAllPersonnelList();
        return new ResponseEntity<List<Personnel>>(personnels, HttpStatus.OK);
    }

    @JsonView(Scope.FirstLevel.class)
    @RequestMapping(value = "/personnels/show/{id}",method = RequestMethod.GET)
    public ResponseEntity<Personnel> getPersonel(@PathVariable Integer id){

        Personnel personnel = personnelService.findById(id);

        System.out.println("----->->>"+id);
        System.out.println("----->>>"+personnel.toString());

        return new ResponseEntity<Personnel>(personnel, HttpStatus.OK);

    }
}
