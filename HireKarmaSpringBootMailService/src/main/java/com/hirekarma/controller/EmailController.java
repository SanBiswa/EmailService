package com.hirekarma.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

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

	@GetMapping("/jobInvitationEmail")
	public String invitationToUniversity(@RequestParam("toUniversities") List<String> university,String attachment) throws MessagingException
	{
		Logger.info("Inside SendingEmailList() Controller...");
		try {
			mailSender.SendEmailListWithAttachment(university,"Job Invitation","Hey we want to conduct a campus drive into your university . . .",attachment);
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Invitation's Failed";
		} catch (IOException e) {
			e.printStackTrace();
			return "Invitation's Failed";
		}
		return "Invitation's Sended Successfully";
	}
	
	@GetMapping("/shortListedApplicant")
	public String shortListedApplicant(@RequestParam("toApplicants") List<String> applicat,String attachment) throws MessagingException
	{
		Logger.info("Inside SendingEmailList() Controller...");
		try {
			mailSender.SendEmailListWithAttachment(applicat,"Congratulations !!","Hey Congrats !! You are shortlisted  for this job and shortly we are let we know about our onboarding process till than enjoy champ . . .",attachment);
		} catch (MessagingException e) {
			e.printStackTrace();
			return "Failed !!";
		} catch (IOException e) {
			e.printStackTrace();
			return "Failed !!";
		}
		return "Email Sended Successfully";
	}
	
	@GetMapping("/hiringMeetEmail")
	public String hiringMeetEmail(@RequestParam("toApplicants") List<String> applicat,String attachment) throws MessagingException
	{
		Logger.info("Inside SendingEmailList() Controller...");
		try {
			mailSender.sendHiringMeetEmail(applicat,"Congratulations !!",attachment);
		} catch (MessagingException e) {
			e.printStackTrace();
			return "hiringMeetEmail Failed !!";
		} catch (IOException e) {
			e.printStackTrace();
			return "hiringMeetEmail Failed !!";
		}
		return "HiringMeetEmail Sended Successfully";
	}

}
