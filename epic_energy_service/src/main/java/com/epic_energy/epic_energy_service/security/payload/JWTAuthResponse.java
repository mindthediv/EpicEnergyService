package com.epic_energy.epic_energy_service.security.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
	private String username;
    private String accessToken;
    private String tokenType = "Bearer";
}
