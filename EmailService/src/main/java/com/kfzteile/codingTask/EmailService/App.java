package com.kfzteile.codingTask.EmailService;

import java.io.File;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.println("Enter a CSV File Path : " );
    	String filePath=scan.nextLine();
    	CSVReader csvR=new CSVReader();
    	System.out.println( "The File contents are");
    	csvR.getUsersFromCsvFile(filePath);
        
    }
}
