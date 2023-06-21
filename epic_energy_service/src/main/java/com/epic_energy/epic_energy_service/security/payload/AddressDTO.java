package com.epic_energy.epic_energy_service.security.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {


        String street;
        String houseNumber;
        String country;
        String cap;
        Long municipality_id;
}
