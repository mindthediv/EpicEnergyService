package com.epic_energy.epic_energy_service.security.service;

import com.epic_energy.epic_energy_service.security.payload.LoginDto;
import com.epic_energy.epic_energy_service.security.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
