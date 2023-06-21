package com.epic_energy.epic_energy_service.security.payload;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UtenteDTO {
	 private String nome;
	    private String cognome;
	    private String userName;
	    private String email;
	    private String contactPhone;
}
