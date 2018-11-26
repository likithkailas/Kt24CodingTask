# Kt24CodingTask   

**EMAIL SENDING SERVICE APPLICATION**   

**To Generate the app(executable jar): Enter the below command in the pom.xml folder location**     
maven clean compile install

**Procedure to run the Application:**      
1. Enter the following command in command prompt to run the application    
java -jar ${ABOLUTEPATH_OF_APPLICATION}    
*Example: java - jar EmailServiceApp.jar*     

2. Enter the CSV file location: (Input to the application)    
*Eg: C:\Users\likith\Desktop\sampleData.csv OR    
    C:\Users\likith\Desktop\sampleData      

-------------------------------------------------------------------     
**Implementation Details:**    
1. CSVReader,java: This class extracts the data from th csv file.    
  - splits the line with regex(;) and replace " with empty space    
  - stores the extracted users data (mail, FirstName and LastName)   
  - reads users data having csv file format with UTF-8 encoding    
2. User.Java : Data model containing user data    
3. MailSenderService.java:  This class creates a mock session (testData) and sends mock email using MockMail API(Mime message)    
4. Mock Mail Sender: This class sends mock email o every user after every half a second and acknowledges the user, if email received   

*Note: 
1. A sample Test case has been written to show the testing of single api   
2. Greenmail, Javax mockmails, Dumbster api's can also be used to send mock emails*   
