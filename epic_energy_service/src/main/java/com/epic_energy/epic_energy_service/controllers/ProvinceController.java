package com.epic_energy.epic_energy_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epic_energy.epic_energy_service.models.Province;
import com.epic_energy.epic_energy_service.repositories.ProvinceRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth/province")
public class ProvinceController {

	@Autowired ProvinceRepository  provionceRepository;

	
	@GetMapping("all")
	public List<Province> getAllprovince(){
		return provionceRepository.findAll();
		}
}