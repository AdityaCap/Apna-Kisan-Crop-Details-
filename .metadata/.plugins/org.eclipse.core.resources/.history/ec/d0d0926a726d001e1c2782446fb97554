package com.cropDetails.User.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.util.StreamUtils;

import com.cropDetails.User.Exceptions.ResourceNotFoundException;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;

 

public class CustomErrorDecoder implements ErrorDecoder {

	@Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == 404) {
            String responseBody = getResponseBody(response);
            return new ResourceNotFoundException(responseBody);
        }
        // Handle other errors or return default decoder
        return FeignException.errorStatus(methodKey, response);
    }

 

    private String getResponseBody(Response response) {
        try {
            if (response.body() != null) {
                return StreamUtils.copyToString(response.body().asInputStream(), Charset.defaultCharset());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Resource not found"; // Default message if the response body is empty
    }
}