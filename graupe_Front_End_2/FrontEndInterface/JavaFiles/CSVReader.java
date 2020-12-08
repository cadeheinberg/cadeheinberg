import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.io.FileWriter;

import java.io.*;

public class CSVReader {

    private static Hashtable<String, User_1> usersTable = new Hashtable<>();
    private static Hashtable<String, Ticket_1>ticketsTable = new Hashtable<>();
    public Hashtable getUserTable() {
      return usersTable;
    }
    public Hashtable getTicketTable() {
      return ticketsTable;
    }

    public void readCSVFiles(File file1, File file2){
      readUsersTable(file1);
      readTicketsTable(file2);
    }

  public void readUsersTable(File file) {


    // path of csv file
    //String path = "C:\\Users\\thenarasu\\Documents\\CS400\\hashtable1.csv\\";
    // string Bufferedreader uses to go through the file.
    String line="";
    // default values
    String password ="";
    String name="";
    String contactInfo="";
    Boolean isAdmin= false;
    int id =0;
    //  If the file isn't found it will
    // throw exception
    try {
      // create a new buffered reader with specified path
      BufferedReader br = new BufferedReader(new FileReader(file));
      int x = 0;
      // iterate through the contents
      while ((line = br.readLine()) != null) {
        //System.out.print("here");
        //splits line into array
        String[] values = line.split(",");
        //each part is stored in a variable
        password = values[1];
        name = values[2];
        contactInfo = values[3];
        isAdmin = values[4].equals("yes");
        //id = Integer.valueOf(values[5]);
        //adds User_1 object to hashtable as value for each line in the csv file
        usersTable.put(values[x],new User_1(name, contactInfo, password, isAdmin));
        //x++;
        //System.out.print(values[x]);

      }
    }
    catch (FileNotFoundException e) {

      e.printStackTrace();

    } catch (IOException e) {

      e.printStackTrace();
    }

  }
  public void readTicketsTable(File file) {

    // path of csv file
    //String path = "C:\\Users\\thenarasu\\Documents\\CS400\\hashtable2.csv\\";
    // string Bufferedreader uses to go through the file.
    String line="";
    // default values
    int id = 0;
    String userName="";
    String title="";
    String content= "";
    Boolean isResolved=false;
    //  If the file isn't found it will
    // throw exception
    try {
      // create a new buffered reader with specified path
      BufferedReader br = new BufferedReader(new FileReader(file));
      int x = 0;
      // iterate through the contents
      br.readLine();
      while ((line = br.readLine()) != null) {
        //splits line into array
        String[] values = line.split(",");
        //each part is stored in a variable
        userName = values[1];
        title = values[2];
        content = values[3];
        isResolved = Boolean.valueOf((values[4]));
        //adds User_1 object to hashtable as value for each line in the csv file
        Ticket_1 ticket = new Ticket_1(userName, title, content, isResolved);
        ticketsTable.put((values[x].trim()), ticket);
        usersTable.get(userName).addTicket(ticket);
        //x++;

      }
    }
    catch (FileNotFoundException e) {

      e.printStackTrace();

    } catch (IOException e) {

      e.printStackTrace();
    }

  }

  public void addNewUser(String userName, User_1 user, File file){
    try{
      FileWriter writer = new FileWriter(file, true);
      String output = "";
      output += "\n";
      output += userName;
      output += ",";
      output += user.getPassword();
      output += ",";
      output += user.getName();
      output += ",";
      output += user.getContactInfo();
      output += ",";
      if(user.isAdmin()){
        output += "yes";
      }else{
        output += "no";
      }

      writer.write(output);
      writer.close();

    }catch(Exception e){
      StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            System.out.println(exceptionAsString);
      //e.printStackTrace();
    }
  }
  public void addNewTicket(Ticket_1 ticket, File file){
    try{
      FileWriter writer = new FileWriter(file, true);
      String output = "";
      output += "\n";
      output += ticket.getID();
      output += ",";
      output += ticket.getUserName();
      output += ",";
      output += ticket.getTitle();
      output += ",";
      output += ticket.getContent();
      output += ",";
      if(ticket.isResolved()){
        output += "TRUE";
      }else{
        output += "FALSE";
      }

      writer.write(output);
      writer.close();
    }catch(Exception e){

    }
  }
}
