package com.epic_energy.epic_energy_service.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.enumerated.ERole;
import com.epic_energy.epic_energy_service.models.Customer;
import com.epic_energy.epic_energy_service.models.Invoice;
import com.epic_energy.epic_energy_service.models.User;
import com.epic_energy.epic_energy_service.repositories.CustomerRepository;
import com.epic_energy.epic_energy_service.security.payload.RegisterDto;
import com.epic_energy.epic_energy_service.security.payload.UtenteDTO;
import com.epic_energy.epic_energy_service.security.repository.RoleDAO;
import com.epic_energy.epic_energy_service.security.repository.UtenteDAO;

import jakarta.persistence.EntityExistsException;

@Service
public class UtenteService {
    @Autowired UtenteDAO utenteDAO;
    @Autowired
    RoleDAO roleRepository;
  
    
    
    public User updateUtente(Long user_id,UtenteDTO user) {
       
    	if(!utenteDAO.existsById(user_id)) {
    		throw new EntityExistsException("user non found!");
    	}
    	User u = utenteDAO.findById(user_id).get();
        u.setCognome(user.getCognome());
        u.setContactPhone(user.getContactPhone());
        u.setEmail(user.getEmail());
        u.setNome(user.getNome());
      return  utenteDAO.saveAndFlush(u);
       
    }
    public void addRole(Long user_Id) {
    	if(!utenteDAO.existsById(user_Id)) {
    		throw new EntityExistsException("user non found!");
    	}
    	User u = utenteDAO.findById(user_Id).get();
    	u.getRoles().add(roleRepository.findByRoleName(ERole.ROLE_ADMIN).get());
    	utenteDAO.save(u);		
    }

    
    public Optional<User> findUserById(Long id) {
    	if(!utenteDAO.existsById(id)) {
    		throw new EntityExistsException("user non found!");
    	}
    	
    	return utenteDAO.findById(id);
    }
    
    public User findByUsername(String username) {
    	if(!utenteDAO.existsByUserName(username)) {
    		throw new EntityExistsException("nessun username trovato");
    	}
    return	utenteDAO.findByUserName(username).get();
    }
}
