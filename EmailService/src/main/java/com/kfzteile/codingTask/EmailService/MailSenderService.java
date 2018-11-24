/**
 * @author likit
 */
package com.kfzteile.codingTask.EmailService;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailSenderService {

	public void sendMail(String to, String subject, String msg) throws EmailException {
		Email email = new SimpleEmail();
		email.addTo(to);
		email.setFrom("test@gmail.com");
		email.setSubject(subject);
		email.setMsg(msg);
		email.setHostName("testmail.com");
		email.send();
	}

}
