package com.epic_energy.epic_energy_service.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "adress")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {

    String street;
    int houseNumber;
    // 'località'
    String country;
    int cap;
    Municipality municipality;
}
