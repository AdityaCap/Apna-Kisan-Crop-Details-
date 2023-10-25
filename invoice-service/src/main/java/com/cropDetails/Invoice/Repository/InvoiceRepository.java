package com.cropDetails.Invoice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropDetails.Invoice.Model.Invoice;

public interface InvoiceRepository extends MongoRepository<Invoice, Integer>{

}
