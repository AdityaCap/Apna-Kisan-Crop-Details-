package com.cropDetails.Invoice.ExceptionsTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.cropDetails.Invoice.Exceptions.InSufficentQuantityException;

public class InSufficentQuantityExceptionTest {

    @Test
    public void testInSufficentQuantityException() {
        // Simulate a situation where the exception should be thrown
        assertThrows(InSufficentQuantityException.class, () -> {
            throw new InSufficentQuantityException();
        });
    }
}

