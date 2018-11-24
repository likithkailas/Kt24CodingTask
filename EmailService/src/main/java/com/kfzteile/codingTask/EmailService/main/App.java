/**
 * @author Likith
 *
 */
package com.kfzteile.codingTask.EmailService.main;
import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.mail.internet.AddressException;

import org.apache.commons.mail.EmailException;

import com.kfzteile.codingTask.EmailService.service.CSVReader;
import com.kfzteile.codingTask.EmailService.service.MockMailSender;

public class App {
	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws EmailException
	 * @throws AddressException
	 */
	public static void main(String[] args) throws InterruptedException, EmailException, AddressException {
		//take input from the user console (absolute file path of csv file)
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a CSV File Absolute Path : ");
		String filePath = scan.nextLine();
		// append file extension to absolute path if ".csv" is missed
		if(!filePath.contains(".csv")) {
			filePath=filePath.concat(".csv");
		}
		// store users extracted from CSV file
		CSVReader.loadUsersFromCsvFile(filePath);
		// send mock emails to the users extracted from csv file
		MockMailSender mms = new MockMailSender();
		mms.sendMockEmails();
	}
}
