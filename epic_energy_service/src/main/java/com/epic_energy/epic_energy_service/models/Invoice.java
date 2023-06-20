package com.epic_energy.epic_energy_service.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.epic_energy.epic_energy_service.enumerated.InvoiceState;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "invoices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Invoice {
    @Column(nullable = false)
    int year;
    @Column(nullable = false)
    LocalDate invoiceDate;
    @Column(nullable = false)
    BigDecimal amount;
    @Id
    int invoice_number;
    @Enumerated(EnumType.STRING)
    InvoiceState state;
}
