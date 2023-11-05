package com.cropDetails.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cropDetails.DTO.User;
import com.cropDetails.ErrorDecoder.CustomErrorDecoder;
import com.cropDetails.Exceptions.UserNotRegisteredException;

	

@FeignClient(url = "http://localhost:9090/user", name = "user-service", configuration = CustomErrorDecoder.class)
public interface UserClient {
	
	@GetMapping("isDealer/{id}")
	public ResponseEntity<Boolean> checkIsDealerById(@PathVariable int id);
	@GetMapping("/viewById/{id}")
	public ResponseEntity<User> viewUserById(@PathVariable int id) throws UserNotRegisteredException;

}
