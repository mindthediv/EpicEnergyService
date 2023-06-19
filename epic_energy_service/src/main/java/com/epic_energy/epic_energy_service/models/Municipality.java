package com.epic_energy.epic_energy_service.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
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
@Table(name = "municipalities")
@DiscriminatorValue("municipality")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Municipality extends Province {
    @Column(nullable = true)
    long province_id;
    @Id
    int municipality_id;
    @Column(nullable = true)
    String name;
    @Column(nullable = true)
    String province_name;
    
    
}
