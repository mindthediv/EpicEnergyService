package com.epic_energy.epic_energy_service.models;

import java.time.LocalDate;
import java.util.List;

import com.epic_energy.epic_energy_service.enumerated.CustomerType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    //ragione sociale
    @Column(name = "company_name")
    String companyName; 
    @Id
    String iva;
    @Column(nullable = false, unique = true)
    String email;
    @Column(nullable = true,  name = "subscription_date")
    //Queste date saranno fornite all'iscrizione e in automatico quando il customer effettua una fattura.
    LocalDate subscriptionDate;
    @Column(name = "last_touch_date", nullable = true)
    LocalDate lastTouchDate;
    //logica
    @Column(name = "year_sales", nullable = true)
    int yearSales;
    @Column(nullable = false, unique = true)
    String pec; 
    @Column(nullable = false, unique = true)
    String phone;
    @Column(nullable = false, name = "customer_type")
    @Enumerated(EnumType.STRING)
    CustomerType customerType;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    Address address;
    @OneToOne
    User user;
    @OneToMany
    List<Invoice> customer_invoices;
    // Da qui in poi direi di creare una classe User che sostituirà 'contact'
    // i cui dati li  richiediamo in fase di iscrizione. I dati sopra saranno chiesti successivamente,
    // quando lo User sarà nel db.
    //String contactEmail;
    //String contactName;
    //String contactLastName;
    //int contactPhone;
}
