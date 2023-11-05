package com.cropDetails.Email.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public String sendEmail(String to,String subject,String body)
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("vermaaditya1821@gmail.com");
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setText(body);
		
		mailSender.send(mail);
		
		return "Mail Send Successfully";
		
	}

}
