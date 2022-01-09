package com.hirekarma.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hirekarma.HireKarmaSpringBootMailServiceApplication;
import com.hirekarma.service.EmailSenderService;

@RestController
public class EmailController {
	
	private static final Logger Logger = LoggerFactory.getLogger(HireKarmaSpringBootMailServiceApplication.class);
	
	@Autowired
	public EmailSenderService mailSender;
	
	@GetMapping("/welcomeEmail")
	public String SendingEmail(@RequestParam("toMail") String toMail)
	{
		Logger.info("Inside SendingEmail() Controller...");
		mailSender.SendEmailWithoutAttachment(toMail,"Wishing Mail","Hey Darling How Are You ??");
		return "Email Sended Successfully";
	}
	
	@GetMapping("/welcomeEmailList")
	public String SendingEmailList(@RequestParam("toMail") List<String> toMail)
	{
		Logger.info("Inside SendingEmailList() Controller...");
		mailSender.SendEmailWithoutAttachmentList(toMail,"Wishing Mail","Hey Darling How Are You ??");
		return "Email Sended Successfully";
	}

}
