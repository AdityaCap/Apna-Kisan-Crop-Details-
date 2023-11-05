package com.cropDetails.Invoice.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cropDetails.Invoice.Exceptions.InSufficentQuantityException;
import com.cropDetails.Invoice.Exceptions.InvoiceNotFoundException;
import com.cropDetails.Invoice.Exceptions.InvoiceNotRegisteredException;
import com.cropDetails.Invoice.Exceptions.NoCropsFoundException;
import com.cropDetails.Invoice.Exceptions.NotFarmerException;

@RestControllerAdvice
public class InvoiceExceptionsHandler {
	@ExceptionHandler(InvoiceNotFoundException.class)
	public ResponseEntity<String> handleInvoiceNotFoundException() {
		return new ResponseEntity<>("No invoices found ", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvoiceNotRegisteredException.class)
	public ResponseEntity<String> handleInvoiceNotRegisteredException() {
		return new ResponseEntity<>("No invoices registered . Please do one ", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InSufficentQuantityException.class)
	public ResponseEntity<String> handleInsufficentQuantityException() {
		return new ResponseEntity<>("In sufficent Quantity ", HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(NoCropsFoundException.class)
	public ResponseEntity<String> handleNoCropFoundException() {
		return new ResponseEntity<>("No Crop Found with this id ", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NotFarmerException.class)
	public ResponseEntity<String> handleNotFarmerException() {
		return new ResponseEntity<>("There is no Farmer with Id ", HttpStatus.NOT_FOUND);
	}

}
