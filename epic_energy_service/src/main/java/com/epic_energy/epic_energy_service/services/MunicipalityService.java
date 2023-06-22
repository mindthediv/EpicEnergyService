package com.epic_energy.epic_energy_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.models.Municipality;
import com.epic_energy.epic_energy_service.models.Province;
import com.epic_energy.epic_energy_service.repositories.MunicipalityRepository;
import com.epic_energy.epic_energy_service.repositories.ProvinceRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class MunicipalityService {
     @Autowired
    private MunicipalityRepository municipalityRepository;
     @Autowired ProvinceRepository provinceRepository;

      public void saveMunicipality(Municipality c) {
        municipalityRepository.save(c);
    }
      public void updateMunicipality(long id) {
        if(!municipalityRepository.existsById(id)){
          throw new EntityExistsException("Municipality do not exists");
        }
        Municipality c = municipalityRepository.findById(id).get();
        municipalityRepository.save(c);
    }
      public void removeMunicipality(long id) {
        municipalityRepository.deleteById(id);;
    }
      public Municipality getMunicipality(long id) {
        return municipalityRepository.findById(id).get();
    }
      public List<Municipality> getAllMunicipality() {
        return municipalityRepository.findAll();
    }
     public List<Municipality> getAllMunicipalityByProvince(String province) {
    	Province p = provinceRepository.findById(province).get();
         return municipalityRepository.findByProvincename(p);
     }
}
