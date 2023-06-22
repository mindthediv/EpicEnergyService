package com.epic_energy.epic_energy_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.enumerated.InvoiceState;
import com.epic_energy.epic_energy_service.models.Customer;
import com.epic_energy.epic_energy_service.models.Invoice;
import com.epic_energy.epic_energy_service.repositories.InvoiceRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class InvoiceService {
     @Autowired
    private InvoiceRepository invoiceRepository;
     @Autowired 
     CustomerService customerService;

      public ResponseEntity<?> saveInvoice(String customer_id,Invoice c) {
      Invoice saved =  invoiceRepository.save(c);
      customerService.addInvoice(customer_id, saved.getInvoice_number());
    return ResponseEntity.ok("Saved Succesfull!!");
    }
      public ResponseEntity<?> updateInvoice(Integer id,Invoice c) {
        if(!invoiceRepository.existsById(id)){
          throw new EntityExistsException("Invoice do not exists");
        }
       return ResponseEntity.ok(invoiceRepository.save(c));
    }
      public ResponseEntity<?> updateStateInvoice(String customer_id,Invoice i){
    	  Invoice update = invoiceRepository.findById(i.getInvoice_number()).get();
    	  update.setState(InvoiceState.PAID);
    	  Customer updateCustomer = customerService.getCustomer(customer_id);
    	  updateCustomer.setYearSales(updateCustomer.getYearSales().add(update.getAmount()) );
    	  return ResponseEntity.ok(updateInvoice(i.getInvoice_number(),update));
      }
      public void removeInvoice(Integer id) {
    	  if(!invoiceRepository.existsById(id)){
              throw new EntityExistsException("Invoice do not exists");
            }
        invoiceRepository.deleteById(id);;
    }
      public Invoice getInvoice(Integer id) {
    	  if(!invoiceRepository.existsById(id)){
              throw new EntityExistsException("Invoice do not exists");
            }
        return invoiceRepository.findById(id).get();
    }
      

      
}
