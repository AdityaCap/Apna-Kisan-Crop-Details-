package com.cropDetails.User.Clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cropDetails.User.Dto.Invoice;
import com.cropDetails.User.ErrorDecoder.CustomErrorDecoder;

@FeignClient(name = "invoice-service", url = "http://localhost:9092/invoice", configuration = CustomErrorDecoder.class)
public interface InvoiceClient {
	@PostMapping("/generate")
	public ResponseEntity<Invoice> generateInvoice(@RequestBody Invoice invoice);

	@DeleteMapping("/cancel/{invoiceId}")
	public ResponseEntity<Boolean> cancelInvoice(@PathVariable int invoiceId);

	@GetMapping("/all")
	public ResponseEntity<List<Invoice>> getAllInvoices();
}
