package com.myWebService.futusistDemo.services;

import com.myWebService.futusistDemo.models.Fonction;

import java.util.List;
import java.util.function.Function;

public interface FonctionService {

    List<Fonction> findAllFunction();

    Fonction saveFunction(Fonction function);

    String saveFunctionState(Fonction function);

}
