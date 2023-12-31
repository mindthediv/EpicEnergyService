package com.epic_energy.epic_energy_service.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epic_energy.epic_energy_service.models.Invoice;
import com.epic_energy.epic_energy_service.services.CustomerService;
import com.epic_energy.epic_energy_service.services.InvoiceService;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getInvoice(@PathVariable long id){
        return ResponseEntity.ok(invoiceService.getInvoice(id));
    }

    @PostMapping("")
    @PreAuthorize("isAuthenticated()")
    public void createInvoice(@RequestBody Invoice i){
        i.setInvoiceDate(LocalDate.now());
        invoiceService.saveInvoice(i);
    }

    //put
    //delete
   
}
