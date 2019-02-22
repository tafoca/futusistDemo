package com.myWebService.futusistDemo.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myWebService.futusistDemo.models.Fonction;
import com.myWebService.futusistDemo.models.Personnel;
import com.myWebService.futusistDemo.models.Realisation;
import com.myWebService.futusistDemo.services.FonctionService;
import com.myWebService.futusistDemo.services.PersonnelService;
import com.myWebService.futusistDemo.services.RealisationService;
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
public class RealisationEndpoint {

    @Autowired
    private FonctionService fonctionService;

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private RealisationService realisationService;

    @RequestMapping(value = "/add-realisation",method = RequestMethod.POST)
    public String saveRealisation(@RequestBody JSONObject realisation) throws ParseException {

        System.out.println(realisation.toJSONString());

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create() ;
        Realisation realisation1 = gson.fromJson(realisation.toJSONString(), Realisation.class);
        System.out.println("realisation : ----->>>>>>>>>>"+ realisation1.toString() + ">><<<<<<<<<<<<<<<<<<<<<<<--------------");

        //construction de la fonction
        String  pers = realisation.get("function").toString();

        System.out.println("---"+pers+ "---");

        Integer id= Integer.parseInt(pers);

        Fonction f = fonctionService.findBYId(id);
        System.out.println(f.toString());

        Object o = new JSONParser().parse(realisation.toJSONString());

        Realisation r = new Realisation(realisation.get("realisationName").toString(),
                realisation.get("description").toString() ,
                realisation.get("beginRealisation").toString() ,
                realisation.get("endRealisation").toString());
        r.setDescription(realisation.get("description").toString());
        r.setFunction(f);

        String ret =  realisationService.saveRealisationState(r);
        System.out.println("------"+ret);
        return ret;
    }

    @RequestMapping(value = "/all-realisations",method = RequestMethod.GET)
    public ResponseEntity<List<Realisation>> getAllRealisation(){

        List<Realisation> realisations = realisationService.findAllRealisation();
        return new ResponseEntity<List<Realisation>>(realisations, HttpStatus.OK);

    }

    @RequestMapping(value = "/realisations/show/{id}",method = RequestMethod.GET)
    public Realisation getRealisation(@PathVariable Integer id){

        Realisation realisation = realisationService.findBYId(id);

        System.out.println("--------------------------"+ realisation.toString()+"--------------------------");

        return realisation;

    }

}
