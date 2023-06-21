package com.epic_energy.epic_energy_service.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.enumerated.ERole;
import com.epic_energy.epic_energy_service.models.Address;
import com.epic_energy.epic_energy_service.models.Customer;
import com.epic_energy.epic_energy_service.models.Province;
import com.epic_energy.epic_energy_service.repositories.CustomerRepository;
import com.epic_energy.epic_energy_service.security.payload.CustomerDto;
import com.epic_energy.epic_energy_service.security.repository.RoleDAO;

import jakarta.persistence.EntityExistsException;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired RoleDAO roleRepository;
    @Autowired AddressService addressService;
    @Autowired MunicipalityService municipalityService;

      public void saveCustomer(CustomerDto cdao) {
    	 Address a = new Address();
    	 a.setCap(cdao.getAddress().getCap());
    	 a.setCountry(cdao.getAddress().getCountry());
    	 a.setStreet(cdao.getAddress().getStreet());
    	 a.setHouseNumber(cdao.getAddress().getHouseNumber());
    	 a.setMunicipality(municipalityService.getMunicipality(cdao.getMunicipality()));
    	Address save = addressService.saveAddress(a);
    	
    	Customer c = new Customer();
        c.setAddress(save);
        c.setCompanyName(cdao.getCompanyName());
        c.setCustomerType(cdao.getCustomerType());
        c.setEmail(cdao.getEmail());
        c.setIva(cdao.getIva());
        c.setPec(cdao.getPec());
        c.setPhone(cdao.getPhone());
    	 c.setSubscriptionDate(LocalDate.now());
    	 c.getUser().getRoles().add(roleRepository.findByRoleName(ERole.ROLE_ADMIN).get()); 
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
