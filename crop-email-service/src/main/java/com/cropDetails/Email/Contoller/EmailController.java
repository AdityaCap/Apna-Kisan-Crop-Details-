package com.cropDetails.Email.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cropDetails.Email.Email;
import com.cropDetails.Email.Service.EmailSenderService;

@RestController
public class EmailController {

	@Autowired
	private final EmailSenderService emailSenderService;
	
	public EmailController(EmailSenderService emailSenderService) {
		super();
		this.emailSenderService = emailSenderService;
	}

	@PostMapping("/send-email")
	public ResponseEntity sendEmail(@RequestBody Email email){
		this.emailSenderService.sendEmail( email.getTo(), email.getSubject(), email.getMessage());
		return ResponseEntity.ok("success");
		
	}
}
