package com.cropDetails.Invoice.Service;

import java.util.List;
import java.util.Optional;

import com.cropDetails.Invoice.Exceptions.InvoiceNotFoundException;
import com.cropDetails.Invoice.Exceptions.InvoiceNotRegisteredException;
import com.cropDetails.Invoice.Model.Invoice;

public interface InvoiceService{

	Optional<Invoice> generateInvoice(Invoice invoice);

	boolean cancelInvoice(int invoiceId) throws InvoiceNotFoundException;

	List<Invoice> getAllInvoices()throws InvoiceNotRegisteredException;

}
