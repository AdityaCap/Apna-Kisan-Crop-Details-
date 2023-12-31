package com.cropDetails.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cropDetails.Exceptions.FarmerAlreadyExistsException;
import com.cropDetails.Exceptions.FarmerNotRegisteredException;
import com.cropDetails.Exceptions.NoFarmerFoundException;

@RestControllerAdvice
public class FarmersExceptionHandler {
	@ExceptionHandler(FarmerNotRegisteredException .class)
	public ResponseEntity<String>handleFarmerNotFoundException(){
		return new ResponseEntity<String>("Farmer is not registered",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoFarmerFoundException .class)
	public ResponseEntity<String>handleNoFarmerFoundException(){
		return new ResponseEntity<String>("NO farmer found ",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(FarmerAlreadyExistsException .class)
	public ResponseEntity<String>handleFarmerAlreadyExistsException(){
		return new ResponseEntity<String>("Farmer already exists ",HttpStatus.NOT_FOUND);
	}
	

}
