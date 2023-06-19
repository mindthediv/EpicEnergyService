package com.epic_energy.epic_energy_service.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {
    int year;
    LocalDate invoiceDate;
    BigDecimal amount;
    int invoiceNumber;
}
