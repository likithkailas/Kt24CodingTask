/**
 * @author Likith
 */
package com.kfzteile.codingTask.EmailService.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.jvnet.mock_javamail.Mailbox;

import com.kfzteile.codingTask.EmailService.service.MailSenderService;

public class MailSenderServiceTest {

	@Test
	public void TestsendEmail() {
		try {
			MailSenderService mailSenderService = new MailSenderService();
			mailSenderService.sendMessage("dummy@gmail.com", "TestMessage", "test");
			Mailbox mailbox = Mailbox.get("dummy@gmail.com");
			assertEquals(1, mailbox.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
