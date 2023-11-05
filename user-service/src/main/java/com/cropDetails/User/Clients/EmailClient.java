package com.cropDetails.User.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cropDetails.User.ErrorDecoder.CustomErrorDecoder;

@FeignClient(url = "http://localhost:7777", name = "crop-email-service", configuration = CustomErrorDecoder.class)
public interface EmailClient {
	@GetMapping("/sendMail/{to}/{subject}/{body}")
	public String sendMail(@PathVariable String to,@PathVariable String subject,@PathVariable String body);

}
