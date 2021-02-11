package com.sharethought.utilites;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component("javaMailSender")
public class MailFunction {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("kundlasiva@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);
        
    }
	
	public void sendEmail(String email,Integer userId) throws Exception {
		
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		
		String userIdStr = userId.toString();
		
		String urlToValidate = env.getProperty("Application.PRESENT_URL")+"validateUser/"+userIdStr;
		
		helper.setTo(email);
		
		helper.setSubject("Verification | Share Your Thought");
		
		String reqText = "<h1>Please click the below link to verify your account </h1> <br>";
		reqText += "<a href='"+urlToValidate+"'> "+ urlToValidate + "</a>"; 
		
		helper.setText(reqText, true);
		
		javaMailSender.send(msg);
	}
	
}
