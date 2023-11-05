package com.cropDetails.Testing;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cropDetails.Exceptions.NoCropRegisteredException;

public class NoCropRegisteredExceptionTest {

    @Test
    public void testNoCropRegisteredException() {
        // Simulate a situation where the exception should be thrown
        assertThrows(NoCropRegisteredException.class, () -> {
            throw new NoCropRegisteredException();
        });
    }

   
}
