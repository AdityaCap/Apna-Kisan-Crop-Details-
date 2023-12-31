package com.cropDetails.Email.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cropDetails.Email.Service.EmailSenderService;

@RestController
public class EmailController {


	@Autowired
	EmailSenderService service;

	@GetMapping("/sendMail/{to}/{subject}/{body}")
	public String sendMail(@PathVariable String to,@PathVariable String subject,@PathVariable String body)
	{
		return service.sendEmail(to, subject, body);
	}
}
