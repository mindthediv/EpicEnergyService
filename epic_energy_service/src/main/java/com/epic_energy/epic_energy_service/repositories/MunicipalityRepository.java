package com.epic_energy.epic_energy_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epic_energy.epic_energy_service.models.Municipality;
import java.util.List;


@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {

	
	public List<Municipality> findByProvincenamesign(String province);
}