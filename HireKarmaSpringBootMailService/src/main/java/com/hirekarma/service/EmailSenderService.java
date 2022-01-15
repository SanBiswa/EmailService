package com.hirekarma.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	private static final Logger Logger = LoggerFactory.getLogger(EmailSenderService.class);
	
	@Autowired
	public JavaMailSender mailSender;
	
	public void SendEmailWithoutAttachment(
			String toEmail,
			String body, 
			String subject){
		
		Logger.info("Inside SendEmailWithoutAttachment() Method...");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setFrom("heydarlinglisten@gmail.com");
		mailMessage.setTo(toEmail);
		mailMessage.setText(body);
		mailMessage.setSubject(subject);
		
		mailSender.send(mailMessage);
		
		Logger.info("Mail Sended Sussessfully WithOut Attachment...");
		
	}
	
	public void SendEmailWithoutAttachmentList(
			List<String> toEmail,
			String body, 
			String subject){
		
		Logger.info("Inside SendEmailWithoutAttachmentList() Method...");
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setFrom("heydarlinglisten@gmail.com");
		mailMessage.setText(body);
		mailMessage.setSubject(subject);
		
		for(String mail : toEmail)
		{
			mailMessage.setTo(mail);
			mailSender.send(mailMessage);
		}
		
		Logger.info("MailList Sended Sussessfully WithOut Attachment...");
		
	}
	
	
	public void SendEmailWithAttachment(
			String toEmail,
			String body, 
			String subject, 
			String attachment) throws MessagingException{
		
		Logger.info("Inside SendEmailWithAttachment() Method...");
		
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
		
		mimeMessageHelper.setFrom("heydarlinglisten@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		mailSender.send(message);
		
		Logger.info("Mail Sended Sussessfully With Attachment...");
		
	}
	
	public void SendEmailListWithAttachment(
			List<String> toEmail,
			String body, 
			String subject, 
			String attachment) throws MessagingException, IOException{
		
		Logger.info("Inside SendEmailWithAttachment() Method...");
		
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
		try {
		mimeMessageHelper.setFrom("heydarlinglisten@gmail.com");
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		for(String mail : toEmail)
		{
			mimeMessageHelper.setTo(mail);
			mailSender.send(message);
		}
		
		mailSender.send(message);
		
		Logger.info("Attachment Mail Sended Sussessfully...");
		} catch (MessagingException e) {
            e.printStackTrace();
        }
		
	}
	
	public void sendHiringMeetEmail(
			List<String> toEmail,
//			String body, 
			String subject, 
			String attachment) throws MessagingException, IOException{
		
		Logger.info("Inside sendHiringMeetEmail() Method...");
		
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
		String body = "<h2>Hey Congrats !!</h2><br>"
				+ " <h3>Please Join On Above Link For Further Process . . .</h3><br><br>"
				+ "<a href='https://www.google.com/'><h3><b>link is here</b></h3></a>";
		try {
		mimeMessageHelper.setFrom("heydarlinglisten@gmail.com");
		mimeMessageHelper.setText(body, true);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		
		for(String mail : toEmail)
		{
			mimeMessageHelper.setTo(mail);
			mailSender.send(message);
		}
		
		mailSender.send(message);
		
		Logger.info("sendHiringMeetEmail Sended Sussessfully...");
		} catch (MessagingException e) {
            e.printStackTrace();
        }
		
	}


}
