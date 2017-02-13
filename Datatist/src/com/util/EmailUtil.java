package com.util;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.pojo.User;

public class EmailUtil {
	public static void sendEmail(User user){
		 JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
	        senderImpl.setHost("smtp.163.com");  
	        SimpleMailMessage mailMessage = new SimpleMailMessage();  
	        mailMessage.setTo(user.getId());  
	        mailMessage.setFrom(" 18848971713@163.com ");  
	        mailMessage.setSubject(" 激活邮件 ");  
	        mailMessage.setText("http://localhost:8080/Datatist/activaion/"+user.getId()+"/"+user.getPassword());  
	  
	        senderImpl.setUsername("18848971713"); 
	        senderImpl.setPassword("syp475422"); 
	  
	        Properties prop = new Properties();  
	        prop.put(" mail.smtp.auth ", " true "); 
	        prop.put(" mail.smtp.timeout ", " 25000 ");  
	        senderImpl.setJavaMailProperties(prop);  

	        senderImpl.send(mailMessage);
	}
}
