package com.epic_energy.epic_energy_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.models.Province;
import com.epic_energy.epic_energy_service.repositories.ProvinceRepository;

import jakarta.persistence.EntityExistsException;

@Service

public class ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

      public void saveProvince(Province c) {
     provinceRepository.save(c);
    }
      public void updateProvince(String id) {
        if( provinceRepository.existsById(id)){
          throw new EntityExistsException("Province do not exists");
        }
        Province c = provinceRepository.findById(id).get();
     provinceRepository.save(c);
    }
      public void removeProvince(String id) {
     provinceRepository.deleteById(id);;
    }
      public Province getProvince(String id) {
        return provinceRepository.findById(id).get();
    }
      public List<Province> getAllProvince() {
        return provinceRepository.findAll();
    }
}
