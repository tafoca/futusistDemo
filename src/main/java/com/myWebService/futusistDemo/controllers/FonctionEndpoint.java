package com.myWebService.futusistDemo.controllers;

import com.myWebService.futusistDemo.models.Fonction;
import com.myWebService.futusistDemo.models.Personnel;
import com.myWebService.futusistDemo.services.FonctionService;
import com.myWebService.futusistDemo.services.PersonnelService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
class FonctionEndpoint {

    @Autowired
    private FonctionService fonctionService;

    @Autowired
    private PersonnelService personnelService;

    @RequestMapping(value = "/add-fonction",method = RequestMethod.POST)
    public String saveFonction(@RequestBody JSONObject fonction) throws ParseException {

        System.out.println(fonction.toJSONString());

        //construction du personnel
        String  pers = fonction.get("personnel").toString();

        Integer id= Integer.parseInt(pers);

        Personnel p = personnelService.findById(id);

         Object o = new JSONParser().parse(fonction.toJSONString());

        Fonction Fonction1 = new Fonction(fonction.get("functionName").toString(),fonction.get("dateDebut").toString(),p);

        return  fonctionService.saveFunctionState(Fonction1);
    }

    @RequestMapping(value = "/all-fonctions",method = RequestMethod.GET)
    public ResponseEntity<List<Fonction>> getAllFonction(){

        List<Fonction> Fonctions = fonctionService.findAllFunction();
        return new ResponseEntity<List<Fonction>>(Fonctions, HttpStatus.OK);

    }

    @RequestMapping(value = "/fonctions/show/{id}",method = RequestMethod.GET)
    public ResponseEntity<Fonction> getFonction(@PathVariable Integer id){

        Fonction fonction = fonctionService.findBYId(id);

        System.out.println("--------------------------"+ fonction.toString()+"--------------------------");

        return new ResponseEntity<Fonction>(fonction, HttpStatus.OK);

    }

}
