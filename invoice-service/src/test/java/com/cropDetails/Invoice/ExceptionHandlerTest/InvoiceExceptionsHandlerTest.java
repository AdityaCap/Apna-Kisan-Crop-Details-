package com.cropDetails.Invoice.ExceptionHandlerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.cropDetails.Invoice.ExceptionHandler.InvoiceExceptionsHandler;
import com.cropDetails.Invoice.Exceptions.InSufficentQuantityException;
import com.cropDetails.Invoice.Exceptions.InvoiceNotFoundException;
import com.cropDetails.Invoice.Exceptions.InvoiceNotRegisteredException;
import com.cropDetails.Invoice.Exceptions.NoCropsFoundException;
import com.cropDetails.Invoice.Exceptions.NotFarmerException;

public class InvoiceExceptionsHandlerTest {

    private final InvoiceExceptionsHandler exceptionHandler = new InvoiceExceptionsHandler();

    @Test
    public void testHandleInvoiceNotFoundException() {
        ResponseEntity<String> response = exceptionHandler.handleInvoiceNotFoundException();
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No invoices found ", response.getBody());
    }

    @Test
    public void testHandleInvoiceNotRegisteredException() {
        ResponseEntity<String> response = exceptionHandler.handleInvoiceNotRegisteredException();
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No invoices registered . Please do one ", response.getBody());
    }

    @Test
    public void testHandleInsufficentQuantityException() {
        ResponseEntity<String> response = exceptionHandler.handleInsufficentQuantityException();
        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
        assertEquals("In sufficent Quantity ", response.getBody());
    }

    @Test
    public void testHandleNoCropFoundException() {
        ResponseEntity<String> response = exceptionHandler.handleNoCropFoundException();
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No Crop Found with this id ", response.getBody());
    }

    @Test
    public void testHandleNotFarmerException() {
        ResponseEntity<String> response = exceptionHandler.handleNotFarmerException();
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("There is no Farmer with Id ", response.getBody());
    }
}
