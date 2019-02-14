package com.myWebService.futusistDemo.repositories;

import com.myWebService.futusistDemo.models.Realisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealisationRepository  extends JpaRepository<Realisation,Integer> {
}
