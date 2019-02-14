package com.myWebService.futusistDemo.services;

import com.myWebService.futusistDemo.models.Realisation;
import com.myWebService.futusistDemo.repositories.RealisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
@Repository
public class RealisationServiceImpl implements RealisationService {

    @Autowired
    RealisationRepository realisationRepository;

    @Override
    public List<Realisation> findAllRealisation() {
        return realisationRepository.findAll();
    }

    @Override
    public Realisation saveRealisation(Realisation realisation) {
        return realisationRepository.save(realisation);
    }

    @Override
    public String saveRealisationState(Realisation realisation) {
        if (saveRealisation(realisation) != null ) return "success"; else return "echec";
    }

    @Override
    public Realisation findBYId(Integer id) {
        return realisationRepository.getOne(id);
    }


}
