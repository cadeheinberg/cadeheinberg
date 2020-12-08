// --== CS400 File Header Information ==--
// Name: Elan Graupe
// Email: graupe@wisc.edu
// Team: BG
// Role: Front End Developer 2
// TA: Brianna Cochran
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

/**
 * Class called by website through CGI script to handle logging in user
 * 
 * @author Elan Graupe
 *
 */
class LogIn {

  /**
   * Main method called by CGI script to log user in. Prints userID to send back to website through
   * API
   * 
   * @param args - username and password in the following format:
   *             "userName=[userName]&password=[password]"
   */
  public static void main(String[] args) {
    try {
      String[] temp = args[0].split("&"); // Split arguments into individual components

      String userName = temp[0].split("=")[1].trim(); // Parse username and password from argument
      String password = temp[1].split("=")[1].trim();

      String userID = getUserID(userName, password); // Get userID from username and password

      System.out.print(GetUserInfo.getUserInfo(userID)); // Print userID to send it back to the
                                                         // website through API
    } catch (Exception e) {
      System.out.print("-1"); // Print -1 if something goes wrong
      e.printStackTrace();

    }
  }

  /**
   * Method interfaces with backend to get userID
   * 
   * @param userName - username of user
   * @param password - password of user
   * @return - userID
   */
  static String getUserID(String userName, String password) {
    Back_End_1 backend = new Back_End_1();
    User_1 user = backend.login(userName, password);
    if (user != null) {
      return "" + userName + "|" + password;
    } else {
      return "-1";
    }

    /*
     * if(userName.toLowerCase().equals("customer")){ return "[defaultCustomer]"; }else
     * if(userName.toLowerCase().equals("admin")){ return "[defaultAdmin]"; } return "-1";
     */
  }
}
