package ec.gob.educacion.teletrabajo.util;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserMailerService {
	
	@Autowired
	private JavaMailSender mailSender;
	@Value("${spring.mail.username}")
	 private String mailRemitente;


	@Async
	public void createAndSendMessage(String to, String subject, String text) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

		try {
			message.setFrom(new InternetAddress(mailRemitente));
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text, true);
			mailSender.send(mimeMessage);
		} catch (MessagingException ex) {
			ex.printStackTrace();
		} catch (MailException ex) {
			ex.printStackTrace();
		}
	}


}
