package com.cropDetails.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cropDetails.Exceptions.CropAlreadyExistException;
import com.cropDetails.Exceptions.NoCropFoundException;
import com.cropDetails.Exceptions.NoCropRegisteredException;
import com.cropDetails.Exceptions.NoSubscriptionFoundException;
import com.cropDetails.Exceptions.NoUserFoundException;
import com.cropDetails.Exceptions.NotDealerException;
import com.cropDetails.Exceptions.SubscriptionAlreadyExistsException;
import com.cropDetails.Exceptions.UserNotRegisteredException;



@RestControllerAdvice
public class CropExceptionHandler {
	@ExceptionHandler(NoCropRegisteredException .class)
	public ResponseEntity<String>handleCropNotRegisteredException(){
		return new ResponseEntity<String>("Crop is not registered with us ",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(CropAlreadyExistException .class)
	public ResponseEntity<String>handleCropAlreadyFoundException(){
		return new ResponseEntity<String>("This Crop already exists with us ",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoCropFoundException .class)
	public ResponseEntity<String>handleNoCropFoundException(){
		return new ResponseEntity<String>("There are no Crops registered .Please first add one ",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SubscriptionAlreadyExistsException .class)
	public ResponseEntity<String>handleSubscriptionAlreadyExistsException(){
		return new ResponseEntity<String>("Subscription already exists for this user and crop type.",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoSubscriptionFoundException.class)
	public ResponseEntity<String>handleNoSubscriptionFoundException(){
		return new ResponseEntity<String>("No subscriptions found.",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NotDealerException.class)
	public ResponseEntity<String>NotDealerException(){
		return new ResponseEntity<String>("User is found but not a dealer.",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<String>NoUserFoundException(){
		return new ResponseEntity<String>("No User Found.",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserNotRegisteredException.class)
	public ResponseEntity<String>UserNotRegisteredException(){
		return new ResponseEntity<String>("No User is registered with us",HttpStatus.NOT_FOUND);
	}

}
