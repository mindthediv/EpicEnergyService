package com.epic_energy.epic_energy_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.models.Customer;
import com.epic_energy.epic_energy_service.models.Province;
import com.epic_energy.epic_energy_service.repositories.CustomerRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

      public void saveCustomer(Customer c) {
        customerRepository.save(c);
    }
      public void updateCustomer(long id) {
        if(!customerRepository.existsById(id)){
          throw new EntityExistsException("Customer do not exists");
        }
        Customer c = customerRepository.findById(id).get();
        customerRepository.save(c);
    }
      public void removeCustomer(long id) {
        customerRepository.deleteById(id);;
    }
      public Customer getCustomer(long id) {
        return customerRepository.findById(id).get();
    }

}
