package com.cropDetails.Invoice.ControllerTestCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cropDetails.Invoice.Controller.InvoiceController;
import com.cropDetails.Invoice.Exceptions.InSufficentQuantityException;
import com.cropDetails.Invoice.Exceptions.InvoiceNotFoundException;
import com.cropDetails.Invoice.Exceptions.InvoiceNotRegisteredException;
import com.cropDetails.Invoice.Exceptions.NoCropsFoundException;
import com.cropDetails.Invoice.Exceptions.NotFarmerException;
import com.cropDetails.Invoice.Model.Invoice;
import com.cropDetails.Invoice.Service.InvoiceService;

public class InvoiceControllerTest {
	private InvoiceController invoiceController;
	

	@Mock
	private InvoiceService invoiceService;

	@BeforeEach
	void setUp() {
		invoiceService = Mockito.mock(InvoiceService.class);
		invoiceController = new InvoiceController(invoiceService);
	}

	@Test
	public void testGenerateInvoice() {
		Invoice invoice = new Invoice(); // Create an Invoice object

		when(invoiceService.generateInvoice(invoice)).thenReturn(Optional.of(invoice));

		ResponseEntity<Invoice> response = invoiceController.generateInvoice(invoice);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(invoice, response.getBody());
	}

	@Test
	public void testGenerateInvoiceFailed() {
		Invoice invoice = new Invoice(); // Create an Invoice object

		when(invoiceService.generateInvoice(invoice)).thenReturn(Optional.empty());

		ResponseEntity<Invoice> response = invoiceController.generateInvoice(invoice);

		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}

	@Test
	public void testCancelInvoice() throws InvoiceNotFoundException {
		int invoiceId = 1;

		when(invoiceService.cancelInvoice(invoiceId)).thenReturn(true);

		ResponseEntity<Boolean> response = invoiceController.cancelInvoice(invoiceId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(true, response.getBody());
	}

	@Test
	public void testGetAllInvoices() throws InvoiceNotRegisteredException {
		List<Invoice> invoices = new ArrayList<>();
		when(invoiceService.getAllInvoices()).thenReturn(invoices);

		ResponseEntity<List<Invoice>> response = invoiceController.getAllInvoices();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(invoices, response.getBody());
	}

	@Test
	public void testBuyCrops() throws InSufficentQuantityException, NoCropsFoundException, NotFarmerException {
		Invoice invoice = new Invoice(); // Create an Invoice object

		when(invoiceService.buyCrops(invoice)).thenReturn(Optional.of(invoice));

		ResponseEntity<Invoice> response = invoiceController.createTicket(invoice);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(invoice, response.getBody());
	}
}
