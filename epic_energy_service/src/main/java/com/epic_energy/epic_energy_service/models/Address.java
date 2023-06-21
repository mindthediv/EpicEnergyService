package com.epic_energy.epic_energy_service.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long address_id;
    @Column(nullable = false)
    String street;
    @Column(nullable = false, name = "house_number")
    String houseNumber;
    // 'località'
    @Column(nullable = false)
    String country;
    @Column(nullable = false)
    String cap;
    @OneToOne(fetch = FetchType.EAGER)
    Municipality municipality;
}
