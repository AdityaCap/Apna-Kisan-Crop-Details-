package com.cropDetails.Testing;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cropDetails.Exceptions.CropAlreadyExistException;

public class CropAlreadyExistExceptionTest {

    @Test
    public void testCropAlreadyExistException() {
        // Simulate a situation where the exception should be thrown
        assertThrows(CropAlreadyExistException.class, () -> {
            throw new CropAlreadyExistException();
        });
    }

    
}
