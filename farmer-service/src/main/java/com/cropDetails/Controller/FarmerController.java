package com.cropDetails.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropDetails.Exceptions.FarmerAlreadyExistsException;

import com.cropDetails.Exceptions.FarmerNotRegisteredException;
import com.cropDetails.Exceptions.NoFarmerFoundException;
import com.cropDetails.Model.Farmer;
import com.cropDetails.Service.IFarmerService;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
	@Autowired
	IFarmerService ser;
	//Admin
	@PostMapping("/addFarmer")
	public ResponseEntity<Farmer>addFarmer(@RequestBody Farmer farmer) throws FarmerAlreadyExistsException{
		Optional<Farmer> f=ser.addfarmer(farmer);
		
		return new ResponseEntity<Farmer>(f.get(),HttpStatus.OK);
		
	}
	//Admin
	@GetMapping("/all")
	public ResponseEntity<List<Farmer>> viewAllFarmers()throws NoFarmerFoundException{
		
		return new ResponseEntity<List<Farmer>>(ser.viewAllFarmers(), HttpStatus.OK);
	}
	//Admin
	@GetMapping("/viewById/{id}")
	public ResponseEntity<Farmer>viewFarmerById(@PathVariable int id) throws FarmerNotRegisteredException {
		Optional<Farmer> f=ser.viewFarmerById(id);
		return new ResponseEntity<Farmer>(f.get(),HttpStatus.OK);
	}
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Boolean>deleteFarmerById(@PathVariable int id) throws FarmerNotRegisteredException {
		return new ResponseEntity<Boolean>(ser.deleteFarmerById(id),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Farmer>updateFarmer(@RequestBody Farmer farmer)throws FarmerNotRegisteredException {
		Optional<Farmer> f=ser.updateFarmer(farmer);
		return new ResponseEntity<Farmer>(f.get(),HttpStatus.OK);
	}
	
	

}
