package com.epic_energy.epic_energy_service.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.epic_energy.epic_energy_service.models.Invoice;
import com.epic_energy.epic_energy_service.services.CustomerService;
import com.epic_energy.epic_energy_service.services.InvoiceService;
import com.epic_energy.epic_energy_service.services.UtenteService;

@RestController
@RequestMapping("api/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;
    @Autowired 
    UtenteService utenteService;
 

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> getInvoice(@PathVariable Integer id){
        return ResponseEntity.ok(invoiceService.getInvoice(id));
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public void createInvoice(@RequestParam String customer_id,@RequestBody Invoice i){
        i.setInvoiceDate(LocalDate.now());
        invoiceService.saveInvoice(customer_id,i);
     
        
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> modifyInvoce(@PathVariable Integer Id){
    	Invoice i = invoiceService.getInvoice(Id);
    	invoiceService.updateInvoice(Id, i);
    return ResponseEntity.ok("fattura aggiornata")	;
    }
    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> removeInvoice(@PathVariable Integer id){
    	invoiceService.removeInvoice(id);
    	return ResponseEntity.ok("Fattura eliminata");
    }
    
   
}
