package com.epic_energy.epic_energy_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epic_energy.epic_energy_service.models.Customer;
import com.epic_energy.epic_energy_service.security.payload.CustomerDto;
import com.epic_energy.epic_energy_service.services.CustomerService;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

	@Autowired CustomerService customerService;
	
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getCustomer(@PathVariable long id){
		return ResponseEntity.ok(customerService.getCustomer(id));
	}
	@PostMapping()
	@PreAuthorize("USER")
	public void createCustomer(@RequestBody CustomerDto c) {
		//service , da dto a entità
		 customerService.saveCustomer(c);
	}
	
//	@PutMapping("/{id}") 
//	public ResponseEntity<?> updateCustomer(@PathVariable long id,@RequestBody Customer c){
//		return ResponseEntity.ok(customerService.updateCustomer(c));
//	}
//	
	
	
}
