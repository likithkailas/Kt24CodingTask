/**
 * @author likit
 */
package com.kfzteile.codingTask.EmailService;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	static List<User> users = new ArrayList<User>();

	private static final String SEMICOLON_DELIMITER = ";";

	public static void loadUsersFromCsvFile(String fileName) {
		String line = "";
		BufferedReader fileReader = null;
		int iterator = 0;// to skip first line of CSV since it contains headers1

		try {
			fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF8"));
			while ((line = fileReader.readLine()) != null) {
				if (iterator != 0) {
					String[] valueList = line.split(SEMICOLON_DELIMITER);
					User user = new User();
					user.setEmail(valueList[0].replace("\"", ""));
					user.setFirstName(valueList[1].replace("\"", ""));
					user.setLastName(valueList[2].replace("\"", ""));
					System.out.println("Email: " + valueList[0].replace("\"", "") + "  " + "FirstName: "
							+ valueList[1].replace("\"", "") + "  " + "LastName: " + valueList[2].replace("\"", ""));
					users.add(user);

				}
				iterator++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
