// --== CS400 File Header Information ==--
// Name: Elan Graupe
// Email: graupe@wisc.edu
// Team: BG
// Role: Front End Developer 2
// TA: Brianna Cochran
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

/**
 * Class called by website through CGI script to create a new user
 * 
 * @author Elan Graupe
 *
 */
class SignUp {
  /**
   * Main method called by CGI script to create a new user.
   * 
   * @param args - user information in the following format:
   *             "userName=[userName]&password=[password]&
   *             firstName=[firstName]&lastName=[lastName]&
   *             emailAddress=[emailAddress]&isAdmin=[isAdmin]"
   */
  public static void main(String[] args) {
    try {
      String[] temp = args[0].split("&"); // Split argument into individual components

      String userName = temp[0].split("=")[1]; // Parse data from arguments
      String password = temp[1].split("=")[1];
      String firstName = temp[2].split("=")[1];
      String lastName = temp[3].split("=")[1];
      String emailAddress = temp[4].split("=")[1];
      boolean isAdmin = (temp[5].split("=")[1].equals("true"));

      createAccount(userName, password, firstName, lastName, emailAddress, isAdmin);

      String userID = LogIn.getUserID(userName, password); // Gets User ID to log user in


      System.out.print(GetUserInfo.getUserInfo(userID)); // Print userID to send it back to website
                                                         // through API to log user in
    } catch (Exception e) {
      System.out.print("-1"); // Print -1 if something went wrong

    }
  }

  /**
   * Method to interface with back end to create an account for the user and add it to the hash
   * table
   * 
   * @param userName     - userName of new user
   * @param password     - password of new user
   * @param firstName    - first name of user
   * @param lastName     - last name of user
   * @param emailAddress - email address of user
   * @param isAdmin      - boolean indicating whether or not user is an administrator
   */
  public static void createAccount(String userName, String password, String firstName,
      String lastName, String emailAddress, boolean isAdmin) {

    // Create backend object and load data from the CSV file
    Back_End_1 backend = new Back_End_1();
    backend.readCSV();

    backend.createNewUser((firstName + " " + lastName), emailAddress, userName, password, isAdmin);
  }

}
