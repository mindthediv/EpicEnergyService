package com.epic_energy.epic_energy_service.models;

import java.time.LocalDate;

import com.epic_energy.epic_energy_service.enumerated.CustomerType;

public class Customer {
    //ragione sociale
    String companyName; 
    String iva;
    String email;
    LocalDate subscriptionDate;
    LocalDate lastTouchDate;
    int yearSales;
    String pec;
    int phone;
    CustomerType customerType;
    // Da qui in poi direi di creare una classe User che sostituirà 'contact'
    // i cui dati li  richiediamo in fase di iscrizione. I dati sopra saranno chiesti successivamente, 
    // quando lo User sarà nel db.
    String contactEmail;
    String contactName;
    String contactLastName;
    int contactPhone;
}
