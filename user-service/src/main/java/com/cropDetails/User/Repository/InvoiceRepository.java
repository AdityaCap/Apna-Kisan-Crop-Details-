package com.cropDetails.User.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropDetails.User.Dto.Invoice;

public interface InvoiceRepository extends MongoRepository<Invoice,String>{

	List<Invoice> findByDealerId(int id);

	List<Invoice> findByFarmerId(int id);

}
