package com.hirekarma;

import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.hirekarma.service.EmailSenderService;

@SpringBootApplication
public class HireKarmaSpringBootMailServiceApplication {
	
	@Autowired
	public EmailSenderService mailSender;
	

	public static void main(String[] args) {
		SpringApplication.run(HireKarmaSpringBootMailServiceApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() throws MessagingException {
		List<String> mail=Arrays.asList("sanbiswa22@gmail.com", "user8is2unknown@gmail.com");
		//mailSender.SendEmailWithoutAttachment("sanbiswa22@gmail.com","Welcome To HireKarma Dear !!","Hire Karma");
		//mailSender.SendEmailWithoutAttachmentList(mail, "List Mail Checking Successfull . . .","Mail Check");
		//mailSender.SendEmailWithAttachment("sanbiswa22@gmail.com","Dress Should Be Properly Maintain By All Students","Use Proper Uniform","C:\\Users\\biswa.sahoo\\Desktop\\FIELS\\EXT DRM IMG\\uniform.jpeg");
		}


}
