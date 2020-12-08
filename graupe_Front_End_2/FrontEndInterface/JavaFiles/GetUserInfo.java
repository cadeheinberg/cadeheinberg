// --== CS400 File Header Information ==--
// Name: Elan Graupe
// Email: graupe@wisc.edu
// Team: BG
// Role: Front End Developer 2
// TA: Brianna Cochran
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

/**
 * Class called by website through CGI to get information about a user
 * 
 * @author Elan Graupe
 *
 */
class GetUserInfo {

  /**
   * Main method called by CGI script to get info about user. Prints JSON containing info about user
   * to send back to website
   * 
   * @param args - the username and password of the user in the following format:
   *             "userID=[userName]|[password]"
   */
  public static void main(String[] args) {
    try {
      String userID = args[0].split("=")[1];

      System.out.print(getUserInfo(userID)); // Print JSON to send to website
    } catch (Exception e) {
      System.out.print("-1"); // Print -1 if arguments are incorrect
    }
  }

  public static String getUserInfo(String userID) {
    try {
      Back_End_1 backend = new Back_End_1();
      String[] temp = userID.split("\\|"); // Split the userID into username and password, and call
                                           // login method to get user objectF
      User_1 user = backend.login(temp[0], temp[1]);

      // Get user info from user object
      boolean isAdmin = user.isAdmin();
      String firstName = user.getName();
      String lastName = user.getName();
      String email = user.getContactInfo();
      /*
       * if(userID.equals("[defaultCustomer]")){ isAdmin = false; firstName = "Some Random";
       * lastName = "User"; email = "user@wisc.edu"; }else if(userID.equals("[defaultAdmin]")){
       * isAdmin = true; firstName = "Some Random"; lastName = "Admin"; email = "admin@wisc.edu";
       * }else{ return "-1"; }
       */

      // Put user info into JSON
      return "{\"isAdmin\":\"" + isAdmin + "\",\"firstName\":\"" + firstName + "\",\"lastName\":\""
          + lastName + "\",\"email\":\"" + email + "\",\"userID\":\"" + userID + "\"}";
    } catch (Exception e) {
      e.printStackTrace();
      return "-1"; // Print -1 if user does not exist
    }

  }
}
