// --== CS400 File Header Information ==--
// Name: Michael Berkey
// Email: mberkey@wisc.edu
// Team: BG
// Role: Front End Developer 1
// TA: Bri
// Lecturer: Dahl
// Notes to Grader: none

import java.util.LinkedList;

/**
 * User object to contain all relevant user info.
 */
public class User_1 {

    private String password;
    private String name;
    private String contactInfo;
    private boolean isAdmin;
    private LinkedList<Ticket_1> tickets;

    /**
     * User object constructor
     * @param name full name of the user
     * @param contactInfo email or phone number of the user
     * @param password password for the user account
     * @param isAdmin true if user is an admin, false if otherwise.
     */
    public User_1(String name, String contactInfo, String password, Boolean isAdmin) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.password = password;
        this.isAdmin = isAdmin;

        tickets = new LinkedList<Ticket_1>();
    }

    /**
     * @return user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password new password to be set
     */
    public void setPassword(String password) { this.password = password; }

    /**
     * @return user's full name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name new full name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return user's contact info
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * @param contactInfo new contact info to be set
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    /**
     * @return true if user is an admin, false if otherwise
     */
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * @param admin user's admin status
     */
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    /**
     * @return linked list of user's submitted tickets
     */
    public LinkedList<Ticket_1> getTickets() {
        return tickets;
    }

    /**
     * @param ticket to be added to user's list of tickets
     */
    public void addTicket(Ticket_1 ticket) {
        tickets.add(ticket);
    }
}
