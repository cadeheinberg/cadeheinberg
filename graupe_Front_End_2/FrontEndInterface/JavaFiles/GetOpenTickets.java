// --== CS400 File Header Information ==--
// Name: Elan Graupe
// Email: graupe@wisc.edu
// Team: BG
// Role: Front End Developer 2
// TA: Brianna Cochran
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import java.util.LinkedList;

/**
 * Retrieves a list of tickets from the back end and sends it the we website as a JSON
 *
 * @author Elan Graupe
 */
class GetOpenTickets {

  /**
   * Runs when API is called by website. Prints a JSON of the tickets that is sent back to the
   * website
   *
   * @param args - unused
   */
  public static void main(String[] args) {

    LinkedList<Ticket_1> tickets = getOpenTickets();
    String outputJSON = "";


    Back_End_1 backend = new Back_End_1(); // Create instance of back end and load CSV's to back                                           // end from file
    backend.readCSV();

    for (Ticket_1 t : tickets) { // Increments through every ticket and adds it to the JSON file
      String userName = t.getUserName();
      User_1 user = backend.usersTable.get(userName);
      outputJSON += "{\"customerName\":\"" + user.getName() + "\",\"customerEmail\":\""
          + user.getContactInfo() + "\",\"title\":\"" + t.getTitle() + "\",\"description\":\""
          + t.getContent() + "\"}|";
    }

    System.out.print(outputJSON);
  }

  /**
   * Interfaces wtih the back end to retrieve all the open tickets
   *
   * @return a linked list of tickets
   */
  static LinkedList<Ticket_1> getOpenTickets() {
    Back_End_1 backend = new Back_End_1();
    return backend.getOpenTickets();
  }

}
