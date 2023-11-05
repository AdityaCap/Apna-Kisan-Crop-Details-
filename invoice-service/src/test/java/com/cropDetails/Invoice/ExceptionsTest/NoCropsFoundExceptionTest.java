package com.cropDetails.Invoice.ExceptionsTest;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.cropDetails.Invoice.Exceptions.NoCropsFoundException;

public class NoCropsFoundExceptionTest {

    @Test
    public void testNoCropsFoundException() {
        // Simulate a situation where the exception should be thrown
        assertThrows(NoCropsFoundException.class, () -> {
            throw new NoCropsFoundException();
        });
    }
}
