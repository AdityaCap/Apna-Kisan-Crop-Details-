package com.cropDetails.User.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropDetails.User.Clients.CropClient;
import com.cropDetails.User.Dto.Crop;
import com.cropDetails.User.Dto.CropSubscription;
import com.cropDetails.User.Exceptions.NoUserFoundException;
import com.cropDetails.User.Exceptions.ResourceAlreadyExistsException;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/crop")
@EnableFeignClients(basePackages = "com.CropDetails.User.Clients")
public class CropClientController {
	@Autowired
	CropClient cropClient;
	
	@PreAuthorize("hasAnyRole('FARMER','ADMIN','DEALER')")
	@GetMapping("/getAll")
	public List<Crop>getAllCrops() {
		 return cropClient.viewAllCrops();			
	}
	@PostMapping("/register")
	@PreAuthorize("hasAnyRole('FARMER')")
	public ResponseEntity<Crop> addCrop(@Valid @RequestBody Crop crop) throws ResourceAlreadyExistsException, NoUserFoundException{
		log.info("Saving.. " + crop);
		Crop c=cropClient.addCrop(crop).getBody();
		return new ResponseEntity<Crop>(c,HttpStatus.CREATED);
		
	}

	@PreAuthorize("hasAnyRole('FARMER')")
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Boolean> deleteCropById(@PathVariable int id)throws ResourceAlreadyExistsException, NoUserFoundException{
		log.info("deleting crop with id "+id);		
		return new ResponseEntity<Boolean>(cropClient.deleteCropById(id).getBody(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('FARMER')")
	@PutMapping("/update")
	public ResponseEntity<Crop> updateCrop(@Valid @RequestBody Crop crop)throws ResourceAlreadyExistsException, NoUserFoundException{
		log.info("updating crop with id "+crop.getCId());
		
		return new ResponseEntity<Crop>(cropClient.updateCrop(crop).getBody(),HttpStatus.OK);
		
	}

	@PreAuthorize("hasAnyRole('FARMER','ADMIN')")
	@GetMapping("/getById/{id}")
	public ResponseEntity<Crop> getCropById(@PathVariable int id)throws ResourceAlreadyExistsException, NoUserFoundException{
		log.info("getting crop by id "+cropClient.getCropById(id).toString());
		return new ResponseEntity<Crop>(cropClient.getCropById(id).getBody(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('FARMER','ADMIN','DEALER')")
	@GetMapping("/getByName/{name}")
	public ResponseEntity<Crop> getCropByName(@PathVariable String name)throws ResourceAlreadyExistsException, NoUserFoundException{
		log.info("getting crop by id "+cropClient.getCropByName(name).toString());
		return new ResponseEntity<Crop>(cropClient.getCropByName(name).getBody(),HttpStatus.OK);

	}

	@PreAuthorize("hasAnyRole('FARMER','ADMIN','DEALER')")
	@GetMapping("/getByType/{type}")
	public ResponseEntity<List<Crop>> getCropByType(@PathVariable String type)throws ResourceAlreadyExistsException, NoUserFoundException{
		log.info("getting crop by id "+cropClient.getCropByType(type).toString());
		return new ResponseEntity<List<Crop>>(cropClient.getCropByType(type).getBody(),HttpStatus.OK);

	}

	@PreAuthorize("hasAnyRole('DEALER')")
	@PostMapping("/subscribe")
	public ResponseEntity<String> subscribeToCrop(@Valid @RequestBody CropSubscription request){
		log.info("Dealer is subscribing to crop of type"+request.getCropType());
		return new ResponseEntity<String>(cropClient.subscribeToCrop(request).getBody(),HttpStatus.OK);
		
	}

	@PreAuthorize("hasAnyRole('DEALER','ADMIN')")
	@GetMapping("/getAllSubscriptions")
	public ResponseEntity<List<CropSubscription>> getSubscriptions(){
		log.info("List of all subscriptions a dealer has done");
		return new ResponseEntity<List<CropSubscription>>(cropClient.getSubscription().getBody(),HttpStatus.OK);

		
	}

	@PreAuthorize("hasAnyRole('DEALER','ADMIN')")
	@DeleteMapping("deleteSubscriptionById/{id}")
	public ResponseEntity<Boolean> deleteSubscriptionById(@PathVariable int id){
		log.info("Dealer is deleting subscriptions of id "+id);
		return new ResponseEntity<Boolean>(cropClient.deleteSubscriptionById(id).getBody(),HttpStatus.OK);
		
	}
	//@PreAuthorize("hasAnyRole('FARMER','ADMIN','DEALER')")
	@GetMapping("/getAllCropsByUserId/{uid}")
	public ResponseEntity<List<Crop>>getAllCropsByUserId(@PathVariable int uid)throws NoUserFoundException {
		return new ResponseEntity<List<Crop>>(cropClient.getAllCropsByUserId(uid).getBody(),HttpStatus.OK);
		
	}
	

	 
	
	

}
