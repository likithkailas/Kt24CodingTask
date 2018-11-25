/**
 * @author Likith
 * 
 */
package com.kfzteile.codingTask.EmailService.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSenderService {

	/**
	 * @param emailaddress
	 * @param subject
	 * @param body
	 */
	public void sendMessage(String emailaddress, String subject, String body) {
		try {
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", "myhost");

			Session mailSession = Session.getDefaultInstance(props, null);
			Transport transport = mailSession.getTransport();

			MimeMessage message = new MimeMessage(mailSession);
			message.setSubject(subject);
			message.setContent(body, "text/plain");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailaddress));

			transport.connect();
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			transport.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
