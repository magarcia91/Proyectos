/*
 * package com.email.sender.service;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.mail.MailException; import
 * org.springframework.mail.SimpleMailMessage; import
 * org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.stereotype.Service;
 * 
 * import com.email.sender.model.Email1; import
 * com.email.sender.repository.EmailRepository1;
 * 
 * @Service public class EmailService {
 * 
 * @Autowired private JavaMailSender javaMailSender;
 * 
 * @Autowired EmailRepository1 emailRepository1;
 * 
 * 
 * @Autowired public EmailService(JavaMailSender javaMailSender) {
 * this.javaMailSender = javaMailSender; }
 * 
 * public void sendEmail(Email1 email) throws MailException { SimpleMailMessage
 * mail = new SimpleMailMessage(); mail.setTo("miguelagarciam13@gmail.com");
 * mail.setFrom(email.getEmail()); mail.setSubject("Contacto: " +
 * email.getNombre()); mail.setText(email.getMensaje());
 * 
 * javaMailSender.send(mail);
 * 
 * }
 */