package com.epic_energy.epic_energy_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epic_energy.epic_energy_service.security.payload.RegisterDto;
import com.epic_energy.epic_energy_service.security.payload.UtenteDTO;
import com.epic_energy.epic_energy_service.services.UtenteService;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired UtenteService utenteService;
	
	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> findByUsername(@RequestBody String username) {
		
		return ResponseEntity.ok(utenteService.findByUsername(username));
	}
	
//	@PutMapping("/{id}")
//	@PreAuthorize("hasRole('USER')")
//	public ResponseEntity<?> modifyUser(@PathVariable Long id, @RequestBody UtenteDTO user){
//		return utenteService.updateUtente(id,user);
//	}
}
