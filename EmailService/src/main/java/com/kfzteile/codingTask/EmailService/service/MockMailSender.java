/**
 * @author Likith
 *
 */
package com.kfzteile.codingTask.EmailService.service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.internet.AddressException;

import org.apache.commons.mail.EmailException;
import org.jvnet.mock_javamail.Mailbox;

import com.kfzteile.codingTask.EmailService.user.User;

public class MockMailSender {
	private static Logger log = Logger.getLogger(MockMailSender.class.getName());
	private MailSenderService mailSender;

	/**
	 * Send mock email and acknowledge 
	 * @throws InterruptedException
	 * @throws EmailException
	 * @throws AddressException
	 */
	public void sendMockEmails() throws InterruptedException, EmailException, AddressException {
		mailSender = new MailSenderService();
		Mailbox.clearAll();
		String subject = "Test Subject";
		String body = "Test body message";
		List<User> users = CSVReader.users;
		if (users != null) {
			for (User user : users) {
				mailSender.sendEmail(user.getEmail(), subject, body);
				//wait for half a second
				Thread.sleep(500);
				//check if mail is received and acknowledge
				Mailbox mailbox = Mailbox.get(user.getEmail());
				if (mailbox.size() == 1) {
					log.log(Level.INFO, "Message sent to " + user.getFirstName());
					mailbox.clear();
				}
			}
		}
	}

}
