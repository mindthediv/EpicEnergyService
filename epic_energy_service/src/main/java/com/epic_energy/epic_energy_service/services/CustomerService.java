package com.epic_energy.epic_energy_service.services;

import java.time.LocalDate;

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
    c.setUser(utenteDAO.findById(cdao.getUser_id()).get());
    // Role admin = new Role();
    // admin = roleRepository.findByRoleName(ERole.ROLE_ADMIN).get();
    // c.getUser().getRoles().add(admin);
    // utenteService.updateUtente(c.getUser().getId());
  return  customerRepository.save(c);
  }

  public Customer updateCustomer(long id, Customer c) {
    if (!customerRepository.existsById(id)) {
      throw new EntityExistsException("Customer do not exists");
    }
    Customer old = customerRepository.findById(id).get();
    if (c.getAddress() == null) {
      c.setAddress(old.getAddress());
    }
    if (c.getCompanyName() == null) {
      c.setCompanyName(old.getCompanyName());
    }
    if (c.getCustomerType() == null) {
      c.setCustomerType(old.getCustomerType());
    }
    if (c.getEmail() == null) {
      c.setEmail(old.getEmail());
    }
    if (c.getIva() == null) {
      c.setIva(old.getIva());
    }
    if (c.getPec() == null) {
      c.setPec(old.getPec());
    }
    if (c.getPhone() == null) {
      c.setPhone(old.getPhone());
    }

    return customerRepository.save(c);
  }

  public void removeCustomer(long id) {
    customerRepository.deleteById(id);
    ;
  }

  public Customer getCustomer(long id) {
    return customerRepository.findById(id).get();
  }

}
