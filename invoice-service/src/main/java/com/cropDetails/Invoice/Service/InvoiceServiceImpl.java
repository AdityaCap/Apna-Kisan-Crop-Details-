package com.cropDetails.Invoice.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.cropDetails.Invoice.Clients.CropClient;
import com.cropDetails.Invoice.Clients.UserClient;
import com.cropDetails.Invoice.Dto.Crop;
import com.cropDetails.Invoice.Dto.User;
import com.cropDetails.Invoice.Exceptions.InvoiceNotFoundException;
import com.cropDetails.Invoice.Exceptions.InvoiceNotRegisteredException;
import com.cropDetails.Invoice.Model.Invoice;
import com.cropDetails.Invoice.Repository.InvoiceRepository;

@Service
@EnableFeignClients(basePackages="com.cropDetails.Invoice.Clients")

public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepository repo;
	
	@Autowired
	UserClient user;
	
	@Autowired
	CropClient crop;

	@Override
	public Optional<Invoice> generateInvoice(Invoice invoice) {
		User farmer = user.viewUserById(invoice.getFarmerId());
		System.out.println(farmer);
		User dealer = user.viewUserById(invoice.getDealerId());
		System.out.println(dealer);
		
		Crop cr = crop.getCropById(invoice.getCropId());
		System.out.println(cr);
		
		//Invoice generatedInvoice = new Invoice(invoice.getInvoiceId(), farmer.getUId(), dealer.getUId(), cr.getCropId(),
			//	invoice.getQuantity(), invoice.getTotalCost(), invoice.getDateOfPurhase());

		repo.save(invoice);
		return Optional.of(invoice);
	}

	@Override
	public boolean cancelInvoice(int invoiceId) throws InvoiceNotFoundException {

		Optional<Invoice> i = repo.findById(invoiceId);
		if (i.isEmpty()) {
			throw new InvoiceNotFoundException();
		}
		repo.deleteById(invoiceId);
		return true;
	}

	@Override
	public List<Invoice> getAllInvoices() throws InvoiceNotRegisteredException {
		List<Invoice> l = repo.findAll();
		if (l.isEmpty()) {
			throw new InvoiceNotRegisteredException();
		}
		return l;
	}

}