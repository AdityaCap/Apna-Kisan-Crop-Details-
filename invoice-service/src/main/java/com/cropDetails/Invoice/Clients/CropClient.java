package com.cropDetails.Invoice.Clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cropDetails.Invoice.Dto.Crop;
import com.cropDetails.Invoice.ErrorDecoder.CustomErrorDecoder;

@FeignClient(name = "crop-service", url = "http://localhost:9091/crop", configuration = CustomErrorDecoder.class)
public interface CropClient {
	
	@GetMapping("/getById/{id}")
	public Crop getCropById(@PathVariable int id);

}
