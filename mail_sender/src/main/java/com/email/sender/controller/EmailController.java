package com.email.sender.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.sender.model.Email1;
import com.email.sender.service.EmailService1;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmailController {
	
	@Autowired
	EmailService1 service;
	
    public EmailController(EmailService1 service) {
        this.service = service;
    }
    
	@GetMapping(value = "/emails") 
    public ResponseEntity <List<Email1>> listMails() {
		List<Email1> email = service.list();
		System.out.println("All Emails...");
		return new ResponseEntity<>(email, HttpStatus.OK);
	}

    @PostMapping("/emails/sendEmail")
    public ResponseEntity<String> sendMail(@RequestBody Email1 mail) {
    	System.out.println("Sending Email...");
    	service.sendEmail(mail);        
        return new ResponseEntity<>("Email was sent successfully!!!", HttpStatus.OK);
    }

	/*
	 * @PostMapping("/emails/sendEmailWithAttachment") public ResponseEntity<String>
	 * sendAttachmentEmail(@RequestBody Email1 mail) throws MessagingException {
	 * service.sendMailWithAttachments(mail); return new
	 * ResponseEntity<>("Email with attachment was sent successfully!!!",
	 * HttpStatus.OK); }
	 */

	/*
	 * @Autowired private EmailService emailService;
	 * 
	 * @GetMapping(value = "/mails") public List<Email1> listMails() {
	 * System.out.println("All Emails..."); return emailService.list();
	 * 
	 * }
	 * 
	 * @PostMapping(value = "/email") public ResponseEntity<Email1>
	 * enviarEmail(@RequestBody Email1 email) { try {
	 * System.out.println("Sending Email..."); emailService.sendEmail(email);
	 * System.out.println("Email was sent succesfully!!!"); return new
	 * ResponseEntity<>(email, HttpStatus.OK); } catch (MailException e) {
	 * System.out.println("Failed to send Email!!!"); return new
	 * ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); }
	 * 
	 * }
	 */
	/*
	 * @Autowired private EmailService1 emailService1;
	 * 
	 * @GetMapping(value = "/mails") public List<Email> listMails() {
	 * System.out.println("All Emails..."); return emailService1.list(); }
	 * 
	 * @PostMapping(value = "/sendEmail") public long save(@RequestBody Email email)
	 * { System.out.println("send mail!!"); return emailService1.sendEmail(email); }
	 * 
	 * @PostMapping(value = "/sendEmailAttachment") public ResponseEntity<String>
	 * sendAttachment(@RequestBody Email email) throws MessagingException{
	 * System.out.println("send mail with attachment!!");
	 * emailService1.sendMailWithAttachment(email); return new
	 * ResponseEntity<>("Email with attachment send successfully", HttpStatus.OK); }
	 */

	// @PostMapping(value = "/email/attachment")

}
