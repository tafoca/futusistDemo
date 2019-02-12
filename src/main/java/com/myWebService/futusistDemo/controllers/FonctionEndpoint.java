package com.myWebService.futusistDemo.controllers;

import com.myWebService.futusistDemo.models.Fonction;
import com.myWebService.futusistDemo.models.Personnel;
import com.myWebService.futusistDemo.services.FonctionService;
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

import java.util.Date;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class FonctionEndpoint {

    @Autowired
    private FonctionService fonctionService;

    @Autowired
    private PersonnelService personnelService;

    @RequestMapping(value = "/add-fonction",method = RequestMethod.POST)
    public String saveFonction(@RequestBody JSONObject fonction){

        System.out.println(fonction.toJSONString());

        //construction du personnel
        String  pers = fonction.get("personnel").toString();
        Integer id= Integer.parseInt(pers);

        Personnel p = personnelService.findById(id);

        Fonction Fonction1 = new Fonction(fonction.get("functionName").toString(),fonction.get("dateDebut").toString(),p);

        return  fonctionService.saveFunctionState(Fonction1);
    }

    @RequestMapping(value = "/all-fonctions",method = RequestMethod.GET)
    public ResponseEntity<List<Fonction>> getAllFonction(){

        List<Fonction> Fonctions = fonctionService.findAllFunction();
        return new ResponseEntity<List<Fonction>>(Fonctions, HttpStatus.OK);

    }
}
