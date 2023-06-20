package com.epic_energy.epic_energy_service.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.enumerated.ERole;
import com.epic_energy.epic_energy_service.models.Customer;
import com.epic_energy.epic_energy_service.models.Province;
import com.epic_energy.epic_energy_service.repositories.CustomerRepository;
import com.epic_energy.epic_energy_service.security.repository.RoleDAO;

import jakarta.persistence.EntityExistsException;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired RoleDAO roleRepository;

      public void saveCustomer(Customer c) {
    	 c.setSubscriptionDate(LocalDate.now());
    	 c.getUser().getRoles().add(roleRepository.findByRoleName(ERole.ADMIN).get()); 
        customerRepository.save(c);
    }
      public Customer updateCustomer(long id,Customer c) {
        if(!customerRepository.existsById(id)){
          throw new EntityExistsException("Customer do not exists");
        }
        Customer old = customerRepository.findById(id).get();
        if(c.getAddress() == null) {
        	c.setAddress(old.getAddress());
        }
        if(c.getCompanyName() == null) {
        	c.setCompanyName(old.getCompanyName());
        }
        if(c.getCustomerType()==null) {
        	c.setCustomerType(old.getCustomerType());
        }
        if(c.getEmail()==null) {
        	c.setEmail(old.getEmail());
        }
        if(c.getIva()==null) {
        	c.setIva(old.getIva());
        }
        if(c.getPec()==null) {
        	c.setPec(old.getPec());
        }
        if(c.getPhone()==null) {
        c.setPhone(old.getPhone());
        }
        
        return  customerRepository.save(c);
    }
      public void removeCustomer(long id) {
        customerRepository.deleteById(id);;
    }
      public Customer getCustomer(long id) {
        return customerRepository.findById(id).get();
    }

}
