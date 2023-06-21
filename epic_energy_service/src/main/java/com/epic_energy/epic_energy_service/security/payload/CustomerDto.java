package com.epic_energy.epic_energy_service.security.payload;

import com.epic_energy.epic_energy_service.enumerated.CustomerType;
import com.epic_energy.epic_energy_service.models.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    String companyName;
    String iva;
    String email;
    String pec;
    String phone;
    CustomerType customerType;
    AddressDTO addressDTO;
    long user_id;

    @Override
    public String toString() {
        return "CustomerDto [companyName=" + companyName + ", iva=" + iva + ", email=" + email + ", pec=" + pec
                + ", phone=" + phone + ", customerType=" + customerType + "]";
    }
}
