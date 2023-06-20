package com.epic_energy.epic_energy_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.models.Address;
import com.epic_energy.epic_energy_service.repositories.AddressRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class AddressService {
      @Autowired
    private AddressRepository addressRepository;

      public void saveAddress(Address c) {
        addressRepository.save(c);
    }
      public void updateAddress(long id) {
        if(!addressRepository.existsById(id)){
          throw new EntityExistsException("Address do not exists");
        }
        Address c = addressRepository.findById(id).get();
        addressRepository.save(c);
    }
      public void removeAddress(long id) {
        addressRepository.deleteById(id);;
    }
      public Address getAddress(long id) {
        return addressRepository.findById(id).get();
    }
}
