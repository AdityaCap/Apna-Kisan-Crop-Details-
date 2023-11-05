package com.cropDetails.Invoice.ExceptionsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cropDetails.Invoice.Exceptions.ResourceNotFoundException;


public class ResourceNotFoundExceptionTest {

    @Test
    public void testResourceNotFoundException() {
        // Simulate a situation where the exception should be thrown
        assertThrows(ResourceNotFoundException.class, () -> {
            throw new ResourceNotFoundException("Resource not found");
        });
    }

    @Test
    public void testResourceNotFoundExceptionWithMessage() {
        // Simulate a situation where the exception should be thrown with a custom message
        String errorMessage = "Custom error message";
        assertThrows(ResourceNotFoundException.class, () -> {
            throw new ResourceNotFoundException(errorMessage);
        });
    }

    @Test
    public void testResourceNotFoundExceptionMessage() {
        // Simulate a situation where the exception is thrown and check the message
        String errorMessage = "Resource not found";
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            throw new ResourceNotFoundException(errorMessage);
        });
        assertEquals(errorMessage, exception.getMessage());
    }
}