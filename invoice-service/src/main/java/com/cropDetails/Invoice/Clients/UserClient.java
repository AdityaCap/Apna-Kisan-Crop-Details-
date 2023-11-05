package com.cropDetails.Invoice.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cropDetails.Invoice.Dto.User;
import com.cropDetails.Invoice.ErrorDecoder.CustomErrorDecoder;

@FeignClient(name = "user-service", url = "http://localhost:9090/user", configuration = CustomErrorDecoder.class)
public interface UserClient {
	@GetMapping("/viewById/{id}")
	public User viewUserById(@PathVariable int id);

	@GetMapping("isDealer/{id}")
	public ResponseEntity<Boolean> checkIsDealerById(@PathVariable int id);
}
