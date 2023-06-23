package com.epic_energy.epic_energy_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epic_energy.epic_energy_service.models.Customer;
import com.epic_energy.epic_energy_service.models.Municipality;
import com.epic_energy.epic_energy_service.models.User;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;



@Repository
public interface CustomerRepository  extends JpaRepository<Customer, String> {
   public Customer findByUser(User u);
 
}
