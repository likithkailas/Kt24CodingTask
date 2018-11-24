/**
 * @author likit
 */
package com.kfzteile.codingTask.EmailService.service.test;

import static org.junit.Assert.*;

import javax.mail.internet.AddressException;

import org.apache.commons.mail.EmailException;
import org.junit.Test;
import org.jvnet.mock_javamail.Mailbox;

import com.kfzteile.codingTask.EmailService.service.MailSenderService;

public class MailSenderServiceTest {

	@Test
	public void TestsendEmail() throws EmailException, AddressException {
		MailSenderService mailSenderService=new MailSenderService();
		mailSenderService.sendEmail("dummy@gmail.com", "TestMessage", "test");
		Mailbox mailbox = Mailbox.get("dummy@gmail.com");
		assertEquals(1, mailbox.size());
	}

}
