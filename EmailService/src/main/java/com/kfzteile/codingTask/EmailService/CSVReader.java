/**
 * @author likit
 */
package com.kfzteile.codingTask.EmailService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

	private static final String SEMICOLON_DELIMITER = ";";

	public List<User> getUsersFromCsvFile(String fileName) {
		String line = "";
		BufferedReader fileReader = null;
		List<User> users=new ArrayList<User>();
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			while ((line = fileReader.readLine()) != null) {
				String[] valueList = line.split(SEMICOLON_DELIMITER);
				User user=new User();
				user.setEmail(valueList[0].replace("\"", ""));
				user.setFirstName(valueList[1].replace("\"", ""));
				user.setFirstName(valueList[2].replace("\"", ""));
				System.out.println("Email: " + valueList[0].replace("\"", "")  +"  "+ "FirstName: " + valueList[1].replace("\"", "") +"  "+ "LastName: " + valueList[2].replace("\"", ""));
				users.add(user);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return users;
	}
	
}
