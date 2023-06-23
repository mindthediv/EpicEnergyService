package com.epic_energy.epic_energy_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epic_energy.epic_energy_service.security.payload.CustomerDto;
import com.epic_energy.epic_energy_service.services.AddressService;
import com.epic_energy.epic_energy_service.services.CustomerService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	AddressService addressService;

	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> getCustomer(@PathVariable String id) {
		return ResponseEntity.ok(customerService.getCustomer(id));
	}

	@PostMapping()
	@PreAuthorize("isAuthenticated()")
	public void createCustomer(@RequestBody CustomerDto c) {
		System.out.println(c);
		customerService.saveCustomer(c);
	}

	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getAllCustomer() {
		return ResponseEntity.ok(customerService.getAllCustomer());
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateCustomer(@PathVariable String id, @RequestBody CustomerDto c) {

		return ResponseEntity.ok(customerService.updateCustomer(id, c));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
		customerService.deleteCustomer(id);

		return ResponseEntity.ok("Customer Deleted");
	}

}
