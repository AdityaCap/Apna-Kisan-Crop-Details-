package com.cropDetails.Invoice.ExceptionsTest;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.cropDetails.Invoice.Exceptions.InvoiceNotFoundException;

public class InvoiceNotFoundExceptionTest {

    @Test
    public void testInvoiceNotFoundException() {
        // Simulate a situation where the exception should be thrown
        assertThrows(InvoiceNotFoundException.class, () -> {
            throw new InvoiceNotFoundException();
        });
    }
}

