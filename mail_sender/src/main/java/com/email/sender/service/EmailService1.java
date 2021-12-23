package com.email.sender.service;

import java.util.List;

import com.email.sender.model.Email1;

public interface EmailService1 {
	
	public List<Email1> list();
    
    public boolean sendEmail(Email1 email1);
    
    public boolean sendEmailTool(String email, String nombre, String mensaje);
    
//	void sendMail(Email1 mail);
//
//  void sendMailWithAttachments(Email1 mail) throws MessagingException;
}

/*
 * package com.email.sender.service;
 * 
 * import java.util.List;
 * 
 * import javax.mail.MessagingException;
 * 
 * import com.email.sender.model.Email;
 * 
 * public interface EmailService1 {
 * 
 * public List<Email> list(); public long sendEmail(Email email); public void
 * sendMailWithAttachment(Email email) throws MessagingException;
 * 
 * }
 */