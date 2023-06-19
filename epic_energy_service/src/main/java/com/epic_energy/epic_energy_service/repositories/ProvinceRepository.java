package com.epic_energy.epic_energy_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.epic_energy.epic_energy_service.models.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {
    public Province findByName(String name);
}
