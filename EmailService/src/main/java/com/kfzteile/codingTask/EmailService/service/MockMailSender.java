/**
 * @author Likith
 *
 */
package com.kfzteile.codingTask.EmailService.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jvnet.mock_javamail.Mailbox;
import com.kfzteile.codingTask.EmailService.user.User;

public class MockMailSender {
	private static Logger log = Logger.getLogger(MockMailSender.class.getName());
	private MailSenderService mailSenderService;

	/**
	 * Send mock email and acknowledge
	 * 
	 * @throws InterruptedException
	 * @throws AddressException
	 */
	public void sendMockEmails() {
		try {
			mailSenderService = new MailSenderService();
			String subject = "Test Subject";
			String body = "Test body message";
			List<User> users = CSVReader.users;
			if (users != null) {
				for (User user : users) {
					mailSenderService.sendMessage(user.getEmail(), subject, body);
					// wait for half a second
					Thread.sleep(500);
					// check if mail is received and acknowledge
					Mailbox mailbox = Mailbox.get(user.getEmail());
					if (mailbox.size() == 1) {
						log.log(Level.INFO, "Message sent to " + user.getFirstName());
						mailbox.clear();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
