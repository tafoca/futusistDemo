package com.myWebService.futusistDemo.services;

import com.myWebService.futusistDemo.models.Fonction;
import com.myWebService.futusistDemo.repositories.FonctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

@Transactional
@Component
@Repository
public class FonctionServiceImpl implements FonctionService {

    @Autowired
    FonctionRepository  fonctionRepository;

    @Override
    public List<Fonction> findAllFunction() {
        return fonctionRepository.findAll();
    }

    @Override
    public Fonction saveFunction(Fonction function) {
        return fonctionRepository.save(function);
    }

    @Override
    public String saveFunctionState(Fonction function) {
       if (saveFunction(function) != null ) return "success"; else return "echec";
    }
}
