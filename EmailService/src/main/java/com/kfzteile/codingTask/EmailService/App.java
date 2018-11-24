package com.kfzteile.codingTask.EmailService;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.mail.internet.AddressException;

import org.apache.commons.mail.EmailException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException, EmailException, AddressException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a CSV File Path : ");
		String filePath = scan.nextLine();
		System.out.println("The File contents are");
		// store users extracted from CSV file
		CSVReader.loadUsersFromCsvFile(filePath);
		// send mock emails to the users extracted from csv file
		MockMailSender mms = new MockMailSender();
		mms.sendMockEmails();
		// C:\Users\likit\Desktop\testCsv.csv
	}
}
