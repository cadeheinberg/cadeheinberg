// --== CS400 File Header Information ==--
// Name: Elan Graupe
// Email: graupe@wisc.edu
// Team: BG
// Role: Front End Developer 2
// TA: Brianna Cochran
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

/**
 * Class called by CGI script. Receives ticket from website and adds it to file and hashtable
 * 
 * @author Elan Graupe
 *
 */
class CreateTicket {

  /**
   * 
   * @param args - The title of the ticket, descripton of the ticket, and the id of the user that
   *             created the ticket
   */
  public static void main(String[] args) {
    try {
      String[] temp = args[0].split("&"); // Split arguments into individual components

      String title = temp[0].split("=")[1]; // parse arguments for litle, description, and userID
      String description = temp[1].split("=")[1];
      String userID = temp[2].split("=")[1];

      createTicket(title, description, userID);
    } catch (Exception e) {
      System.out.print("-1"); // Return -1 if a parameter is missing

    }
  }

  /**
   * Interfaces with the back end to create a new ticket
   * 
   * @param title       - The title of the ticket
   * @param description - The description of the ticket
   * @param userID      - The userID of the user who created the ticket
   */
  public static void createTicket(String title, String description, String userID) {
    // TODO Link to back end's ticket creaation
  }

}
