package com.epic_energy.epic_energy_service.security.service;



public interface AuthService {
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
}
