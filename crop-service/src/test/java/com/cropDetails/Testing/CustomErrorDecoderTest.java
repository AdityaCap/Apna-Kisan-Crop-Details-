//package com.cropDetails.Testing;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.mock.http.client.MockClientHttpResponse;
//import org.springframework.util.StreamUtils;
//
//import com.cropDetails.ErrorDecoder.CustomErrorDecoder;
//import com.cropDetails.Exceptions.ResourceNotFoundException;
//
//import feign.FeignException;
//import feign.Response;
//
//public class CustomErrorDecoderTest {
//
//    @Test
//    public void testDecodeResourceNotFoundException() {
//        // Simulate a 404 response
//        Response response = createMockResponse(404, "Resource not found");
//
//        CustomErrorDecoder decoder = new CustomErrorDecoder();
//        Exception exception = decoder.decode("methodKey", response);
//
//        assertTrue(exception instanceof ResourceNotFoundException);
//        assertEquals("Resource not found", exception.getMessage());
//    }
//
//    @Test
//    public void testDecodeOtherException() {
//        // Simulate a non-404 response
//        Response response = createMockResponse(500, "Internal Server Error");
//
//        CustomErrorDecoder decoder = new CustomErrorDecoder();
//        Exception exception = decoder.decode("methodKey", response);
//
//        assertTrue(exception instanceof FeignException);
//        assertEquals("Internal Server Error", exception.getMessage());
//    }
//
//    private Response createMockResponse(int status, String responseBody) {
//        MockClientHttpResponse mockResponse = new MockClientHttpResponse();
//        ((Object) mockResponse).setRawStatusCode(status);
//        byte[] responseBytes = responseBody.getBytes(Charset.defaultCharset());
//
//        try {
//            StreamUtils.copy(responseBytes, mockResponse.getBody());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Response response = mock(Response.class);
//        when(response.status()).thenReturn(status);
//        when(response.body()).thenReturn(mockResponse);
//
//        return response;
//    }
//}
//
