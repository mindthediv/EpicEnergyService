package com.epic_energy.epic_energy_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.models.User;
import com.epic_energy.epic_energy_service.security.repository.UtenteDAO;

@Service
public class UtenteService {
    @Autowired UtenteDAO utenteDAO;
    
    public String updateUtente(long user_id) {
        User u = utenteDAO.findById(user_id).get();
        utenteDAO.saveAndFlush(u);
        return u.toString();
    }
}
