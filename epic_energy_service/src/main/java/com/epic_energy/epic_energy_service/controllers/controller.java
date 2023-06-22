package com.epic_energy.epic_energy_service.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3002")
public class controller {
    @GetMapping("/api/test")
    public String getTest() {
        return "test2345678";
    }
}
