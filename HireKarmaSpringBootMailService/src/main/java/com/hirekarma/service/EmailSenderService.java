package com.hirekarma.service;

import java.io.File;
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

}
