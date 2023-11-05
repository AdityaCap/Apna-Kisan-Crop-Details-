package com.cropDetails.Testing;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cropDetails.Exceptions.NoSubscriptionFoundException;

public class NoSubscriptionFoundExceptionTest {

    @Test
    public void testNoSubscriptionFoundException() {
        // Simulate a situation where the exception should be thrown
        assertThrows(NoSubscriptionFoundException.class, () -> {
            throw new NoSubscriptionFoundException();
        });
    }

    

}
