package com.epic_energy.epic_energy_service.models;

<<<<<<< HEAD


import jakarta.annotation.Generated;
=======
import com.epic_energy.epic_energy_service.enum.ERole;

>>>>>>> 76da143f89e1a5b267d3b6b4b5f41537100ea9be
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private ERole roleName;
}
