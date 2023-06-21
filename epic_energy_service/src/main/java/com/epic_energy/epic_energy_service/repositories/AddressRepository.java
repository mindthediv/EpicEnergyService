package com.epic_energy.epic_energy_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epic_energy.epic_energy_service.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    
}
