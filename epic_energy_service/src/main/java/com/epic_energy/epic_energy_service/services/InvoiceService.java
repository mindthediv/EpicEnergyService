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

      public void saveInvoice(Invoice c) {
        invoiceRepository.save(c);
    }
      public void updateInvoice(long id) {
        if(!invoiceRepository.existsById(id)){
          throw new EntityExistsException("Invoice do not exists");
        }
        Invoice c = invoiceRepository.findById(id).get();
        invoiceRepository.save(c);
    }
      public void removeInvoice(long id) {
        invoiceRepository.deleteById(id);;
    }
      public Invoice getInvoice(long id) {
        return invoiceRepository.findById(id).get();
    }

}
