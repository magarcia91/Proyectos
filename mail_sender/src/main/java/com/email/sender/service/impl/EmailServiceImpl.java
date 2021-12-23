package com.email.sender.service.impl;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.email.sender.model.Email1;
import com.email.sender.repository.EmailRepository1;
import com.email.sender.service.EmailService1;

@Service
public class EmailServiceImpl implements EmailService1 {
	
	private final JavaMailSender javaMailSender;
	
	@Autowired
	private EmailRepository1 repository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailService1.class);
	
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Override
	public List<Email1> list() {
		return repository.findAll();
	}

	@Override
	public boolean sendEmail(Email1 email1) {
		LOGGER.info("EmailBody: {}", email1.toString());
		return sendEmailTool(email1.getEmail(),email1.getNombre(), email1.getMensaje());
	}

	@Override
	public boolean sendEmailTool(String email, String mensaje, String nombre) {
		boolean send = false;
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);		
		try {
			helper.setTo(email);
			helper.setText(mensaje, true);
			helper.setSubject(nombre);
			javaMailSender.send(message);
			send = true;
			LOGGER.info("Mail enviado!");
		} catch (MessagingException e) {
			LOGGER.error("Hubo un error al enviar el mail: {}", e);
		}
		return send;
	}

	/*
	 * @Override public void sendMail(Email1 mail) {
	 * 
	 * SimpleMailMessage msg = new SimpleMailMessage(); msg.setTo(mail.getEmail(),
	 * mail.getEmail()); msg.setSubject(mail.getNombre());
	 * msg.setText(mail.getMensaje());
	 * 
	 * javaMailSender.send(msg);
	 * 
	 * }
	 * 
	 * @Override public void sendMailWithAttachments(Email1 mail) throws
	 * MessagingException {
	 * 
	 * MimeMessage msg = javaMailSender.createMimeMessage(); MimeMessageHelper
	 * helper = new MimeMessageHelper(msg, true);
	 * helper.setTo("miguelagarciam13@gmail.com");
	 * helper.setSubject("Testing from Spring Boot");
	 * helper.setText("Find the attached image", true);
	 * helper.addAttachment("hero.jpg", new ClassPathResource("hero.jpg"));
	 * 
	 * javaMailSender.send(msg);
	 * 
	 * }
	 */	
}







/*
 * package com.email.sender.service.impl;
 * 
 * import java.util.List;
 * 
 * import javax.mail.MessagingException; import javax.mail.internet.MimeMessage;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.core.io.ClassPathResource; import
 * org.springframework.mail.MailException; import
 * org.springframework.mail.SimpleMailMessage; import
 * org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.mail.javamail.MimeMessageHelper; import
 * org.springframework.stereotype.Service;
 * 
 * import com.email.sender.model.Email; import
 * com.email.sender.repository.EmailRepository; import
 * com.email.sender.service.EmailService1;
 * 
 * @Service public class EmailServiceImpl implements EmailService1 {
 * 
 * @Autowired private JavaMailSender javaMailSender;
 * 
 * @Autowired EmailRepository emailRepository;
 * 
 * 
 * @Override public List<Email> list() { return emailRepository.findAll(); }
 * 
 * @Override public long sendEmail(Email email) throws MailException {
 * 
 * System.out.println("send email...."); SimpleMailMessage msg = new
 * SimpleMailMessage(); msg.setTo(email.getDestinatario());
 * msg.setFrom("miguelagarciam13@gmail.com"); msg.setSubject(email.getAsunto());
 * msg.setText(email.getMensaje()); javaMailSender.send(msg);
 * 
 * return emailRepository.save(email).getId(); }
 * 
 * @Override public void sendMailWithAttachment(Email email) throws
 * MessagingException { MimeMessage msg = javaMailSender.createMimeMessage();
 * MimeMessageHelper helper = new MimeMessageHelper(msg, true);
 * 
 * helper.setTo(email.getDestinatario()); helper.setSubject(email.getAsunto());
 * helper.setText(email.getMensaje(), true); helper.addAttachment("logo.jpg",
 * new ClassPathResource("logo.jpg"));
 * 
 * javaMailSender.send(msg); }
 *  
 * }
 */