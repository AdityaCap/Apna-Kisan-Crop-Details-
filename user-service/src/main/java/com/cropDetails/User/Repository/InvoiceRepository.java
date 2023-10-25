package com.cropDetails.User.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropDetails.User.Dto.Invoice;

public interface InvoiceRepository extends MongoRepository<Invoice,Integer>{

}
