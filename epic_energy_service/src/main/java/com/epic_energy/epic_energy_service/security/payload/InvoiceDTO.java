package com.epic_energy.epic_energy_service.security.payload;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.epic_energy.epic_energy_service.enumerated.InvoiceState;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDTO {

	   
	    int year;
	    
	    LocalDate invoiceDate;
	    
	    BigDecimal amount;
	  
	    InvoiceState state;
	    
	    Long customer_id;
}
