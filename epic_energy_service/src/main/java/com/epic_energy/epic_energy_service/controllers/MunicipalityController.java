package com.epic_energy.epic_energy_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epic_energy.epic_energy_service.models.Province;
import com.epic_energy.epic_energy_service.services.MunicipalityService;



@RestController
@RequestMapping("/api/municipality")
public class MunicipalityController {

	@Autowired MunicipalityService municipalityService;
	
//	@GetMapping
////	@PreAuthorize("isAuthenticate()")
//	public ResponseEntity<List<?>> getAllMunicipality(){
//		return ResponseEntity.ok(municipalityService.getAllMunicipality());
//	}
	
	@GetMapping
//	@PreAuthorize("isAuthenticate()")
	public ResponseEntity<List<?>> getMunicipality(@RequestBody Province p){
		return ResponseEntity.ok(municipalityService.getAllMunicipalityByProvince(p));
	}
}
