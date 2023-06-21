package com.epic_energy.epic_energy_service.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "provinces")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Province {
    @Id
    String sign;
    @Column(nullable = true)
    String name;
    @Column(nullable = true)
    String region;
}
