package com.cropDetails.Invoice.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cropDetails.Invoice.Exceptions.InvoiceNotFoundException;
import com.cropDetails.Invoice.Exceptions.InvoiceNotRegisteredException;

@RestControllerAdvice
public class InvoiceExceptionsHandler {
	@ExceptionHandler(InvoiceNotFoundException.class)
	public ResponseEntity<String>handleInvoiceNotFoundException(){
		return new ResponseEntity<>("No invoices found ",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(InvoiceNotRegisteredException.class)
	public ResponseEntity<String>handleInvoiceNotRegisteredException(){
		return new ResponseEntity<>("No invoices registered . Please do one ",HttpStatus.NOT_FOUND);
	}

}
