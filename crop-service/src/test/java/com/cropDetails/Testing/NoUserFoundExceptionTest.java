package com.cropDetails.Testing;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cropDetails.Exceptions.NoUserFoundException;

public class NoUserFoundExceptionTest {

    @Test
    public void testNoUserFoundException() {
        // Simulate a situation where the exception should be thrown
        assertThrows(NoUserFoundException.class, () -> {
            throw new NoUserFoundException();
        });
    }

    
}
