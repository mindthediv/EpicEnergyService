package com.epic_energy.epic_energy_service.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epic_energy.epic_energy_service.enumerated.ERole;
import com.epic_energy.epic_energy_service.models.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {

	Optional<Role> findByRoleName(ERole roleName);
}
