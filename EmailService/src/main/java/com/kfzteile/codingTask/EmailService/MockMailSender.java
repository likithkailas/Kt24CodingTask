/**
 * @author likit
 */
package com.kfzteile.codingTask.EmailService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.internet.AddressException;

import org.apache.commons.mail.EmailException;
import org.jvnet.mock_javamail.Mailbox;

public class MockMailSender {
	private static Logger log = Logger.getLogger(MockMailSender.class.getName());

	private MailSenderService mailSender;

	public void sendMockEmails() throws InterruptedException, EmailException, AddressException {
		mailSender = new MailSenderService();
		Mailbox.clearAll();
		String subject = "Test Subject";
		String body = "Test body message";
		List<User> users = CSVReader.users;
		if (users != null) {
			for (User user : users) {
				mailSender.sendMail(user.getEmail(), subject, body);
				Thread.sleep(500);
				Mailbox mailbox = Mailbox.get(user.getEmail());
				if (mailbox.size() == 1) {
					log.log(Level.INFO, "Message sent to " + user.getFirstName());
					mailbox.clear();
				}
			}
		}
	}

}