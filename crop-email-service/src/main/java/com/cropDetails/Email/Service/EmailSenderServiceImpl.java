package com.cropDetails.Email.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	@Override
	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setFrom("vermaaditya1821@gmail.com");
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		this.mailSender.send(mailMessage);

		
	}

}
