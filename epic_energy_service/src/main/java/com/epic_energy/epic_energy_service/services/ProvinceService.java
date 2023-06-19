package com.epic_energy.epic_energy_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.models.Province;
import com.epic_energy.epic_energy_service.repositories.ProvinceRepository;

@Service

public class ProvinceService {
    @Autowired
    ProvinceRepository provinceDAO;

    public void saveProvince(Province p) {
        provinceDAO.save(p);
    }
}
