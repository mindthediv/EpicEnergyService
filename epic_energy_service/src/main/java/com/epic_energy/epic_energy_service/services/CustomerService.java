package com.epic_energy.epic_energy_service.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.enumerated.ERole;
import com.epic_energy.epic_energy_service.models.Address;
import com.epic_energy.epic_energy_service.models.Customer;
import com.epic_energy.epic_energy_service.models.Province;
import com.epic_energy.epic_energy_service.models.Role;
import com.epic_energy.epic_energy_service.models.User;
import com.epic_energy.epic_energy_service.repositories.CustomerRepository;
import com.epic_energy.epic_energy_service.security.payload.AddressDTO;
import com.epic_energy.epic_energy_service.security.payload.CustomerDto;
import com.epic_energy.epic_energy_service.security.payload.UtenteDTO;
import com.epic_energy.epic_energy_service.security.repository.RoleDAO;
import com.epic_energy.epic_energy_service.security.repository.UtenteDAO;

import jakarta.persistence.EntityExistsException;

@Service
public class CustomerService {
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  RoleDAO roleRepository;
  @Autowired
  UtenteDAO utenteDAO;
  @Autowired
  UtenteService utenteService;
  @Autowired AddressService addressService;
  @Autowired MunicipalityService municipalityService;

  public Customer saveCustomer(CustomerDto cdao) {
    
	  
	  
	  Address a = new Address();
    a.setCap(cdao.getAddressDTO().getCap());
    a.setCountry(cdao.getAddressDTO().getCountry());
    a.setStreet(cdao.getAddressDTO().getStreet());
    a.setHouseNumber(cdao.getAddressDTO().getHouseNumber());
    a.setMunicipality(municipalityService.getMunicipality(cdao.getAddressDTO().getMunicipality_id()));
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
    utenteService.addRole(cdao.getUser_id());
    c.setUser(utenteService.findUserById(cdao.getUser_id()).get());
  return  customerRepository.save(c);
  }

  public Customer updateCustomer(String id, CustomerDto c) {
    if (!customerRepository.existsById(id)) {
      throw new EntityExistsException("Customer do not exists");
    }
    Customer old = customerRepository.findById(id).get();
    if (c.getAddressDTO() != null) {
    	
    Address a =	old.getAddress();
    
    a.setCap(c.getAddressDTO().getCap());
    a.setCountry(c.getAddressDTO().getCountry());
    a.setStreet(c.getAddressDTO().getStreet());
    a.setHouseNumber(c.getAddressDTO().getHouseNumber());
    a.setMunicipality(municipalityService.getMunicipality(c.getAddressDTO().getMunicipality_id()));
    addressService.updateAddress(c.getUser_id(),a);
    
    }
    if (c.getCompanyName() != null) {
      old.setCompanyName(c.getCompanyName());
    }
    if (c.getCustomerType() != null) {
    	old.setCustomerType(c.getCustomerType());
    }
    if (c.getEmail() != null) {
    	old.setEmail(c.getEmail());
    }
    if (c.getIva() != null) {
      old.setIva(c.getIva());
    }
    if (c.getPec() != null) {
      old.setPec(c.getPec());
    }
    if (c.getPhone() != null) {
      old.setPhone(c.getPhone());
    }

    return customerRepository.save(old);
  }

  public void removeCustomer(String id) {
	  if (!customerRepository.existsById(id)) {
	      throw new EntityExistsException("Customer do not exists");
	    }
    customerRepository.deleteById(id);
    ;
  }
  
  public List<Customer> getAllCustomer(){
	  return customerRepository.findAll();
  }

  public Customer getCustomer(String id) {
	  if (!customerRepository.existsById(id)) {
	      throw new EntityExistsException("Customer do not exists");
	    }
    return customerRepository.findById(id).get();
  }
  
  public String deleteCustomer(String id) {
	  if (!customerRepository.existsById(id)) {
	      throw new EntityExistsException("Customer do not exists");
	    }
	  customerRepository.deleteById(id);
	  return "Deleted";
  }

}
