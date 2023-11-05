package com.cropDetails.Testing;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cropDetails.Exceptions.UserNotRegisteredException;

public class UserNotRegisteredExceptionTest {

    @Test
    public void testUserNotRegisteredException() {
        // Simulate a situation where the exception should be thrown
        assertThrows(UserNotRegisteredException.class, () -> {
            throw new UserNotRegisteredException();
        });
    }

    
}
