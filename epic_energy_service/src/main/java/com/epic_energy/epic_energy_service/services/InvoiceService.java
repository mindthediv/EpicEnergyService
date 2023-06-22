package com.epic_energy.epic_energy_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epic_energy.epic_energy_service.models.Invoice;
import com.epic_energy.epic_energy_service.repositories.InvoiceRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class InvoiceService {
     @Autowired
    private InvoiceRepository invoiceRepository;
     @Autowired 
     CustomerService customerService;

      public void saveInvoice(String customer_id,Invoice c) {
      Invoice saved =  invoiceRepository.save(c);
        
        customerService.addInvoice(customer_id, saved.getInvoice_number());
    }
      public void updateInvoice(Integer id,Invoice c) {
        if(!invoiceRepository.existsById(id)){
          throw new EntityExistsException("Invoice do not exists");
        }
        invoiceRepository.save(c);
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
