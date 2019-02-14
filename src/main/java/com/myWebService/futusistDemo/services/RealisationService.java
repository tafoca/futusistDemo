package com.myWebService.futusistDemo.services;

import com.myWebService.futusistDemo.models.Realisation;

import java.util.List;

public interface RealisationService {

    List<Realisation> findAllRealisation();

    Realisation saveRealisation(Realisation realisation);

    String saveRealisationState(Realisation realisation);

    Realisation findBYId(Integer id);
}
