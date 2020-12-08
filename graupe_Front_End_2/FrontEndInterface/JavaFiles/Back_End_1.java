// --== CS400 File Header Information ==--
// Name: Michael Berkey
// Email: mberkey@wisc.edu
// Team: BG
// Role: Front End Developer 1
// TA: Bri
// Lecturer: Dahl
// Notes to Grader: none

import java.io.File;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;

/**
 * Provides backend for application. Holds hashtable of users and tickets. Provides various
 * methods for accessing and changing user and ticket objects in hashtable.
 */
public class Back_End_1 {

    public Hashtable<String, User_1> usersTable = new Hashtable<>();
    public Hashtable<String, Ticket_1> ticketsTable = new Hashtable<>();
    private CSVReader csvReader = new CSVReader();
    private File usersCSV = new File("hashtable1.csv");
    private File ticketsCSV = new File("hashtable2.csv");

    /**
     * Reads the users and tickets stored in the two csv files and stores them in their
     * respective hashtables.
     */
    public void readCSV() {
        csvReader.readCSVFiles(usersCSV, ticketsCSV);
        usersTable = csvReader.getUserTable();
        ticketsTable = csvReader.getTicketTable();
    }

    /**
     * Creates a new user object and adds it to the user hashtable.
     * @param name full name of the users
     * @param contactInfo email or phone number of user
     * @param userName username used to login
     * @param password password used to login
     * @param isAdmin true if user is an admin, false if not
     * @return true if user is successfully added. False if otherwise.
     */
    public boolean createNewUser(String name, String contactInfo, String userName,
                                 String password, Boolean isAdmin) {
        User_1 user = new User_1(name, contactInfo, password, isAdmin);
        if(usersTable.contains(userName))
            return false;
        usersTable.put(userName, user);
        csvReader.addNewUser(userName, user, usersCSV);
        return true;
    }

    /**
     * Creates a new ticket object and adds it to the ticket hashtable.
     * @param userName username of the user who is submitting the ticket
     * @param title title of the ticket
     * @param content descriptive content of the ticket
     * @return true if the ticket was successfully added. False if otherwise.
     */
    public boolean newTicket(String userName, String title, String content) {
        Ticket_1 ticket = new Ticket_1(userName, title, content);
        if(ticketsTable.contains(ticket.getID()))
            return false;
        ticketsTable.put(ticket.getID(), ticket);
        csvReader.addNewTicket(ticket, ticketsCSV);
        return true;
    }

   /**
     * Creates a new ticket object and adds it to the ticket hashtable (with isResolved param)
     * @param userName username of the user who is submitting the ticket
     * @param title title of the ticket
     * @param content descriptive content of the ticket
     * @return true if the ticket was successfully added. False if otherwise.
     */
    public boolean newTicket(String userName, String title, String content, boolean isResolved) {
        Ticket_1 ticket = new Ticket_1(userName, title, content, isResolved);
        if(ticketsTable.contains(ticket.getID()))
            return false;
        ticketsTable.put(ticket.getID(), ticket);
        csvReader.addNewTicket(ticket, ticketsCSV);
        return true;
    }

    /**
     * Returns a ticket by ID.
     * @param ID UUID value of ticket.
     * @return Ticket object associated with ID.
     */
    public Ticket_1 getTicket(String ID) {
        return ticketsTable.get(ID);
    }

    /**
     * Sets a ticket retrieved by ID to resolved
     * @param ID UUID of ticket to be set to resolved
     * @return true if ticket is set to resolved, false if otherwise
     */
    public boolean resolveTicket(String ID) {
        Ticket_1 ticket = ticketsTable.get(ID);
        if(ticket != null) {
            ticket.setResolved(true);
            return true;
        }
        return false;
    }

    /**
     * Retrieves list of all tickets associated with a user.
     * @param userName username of user that tickets are being retrieved.
     * @return linked list of all tickets submitted by user.
     */
    public LinkedList<Ticket_1> getUserTickets(String userName) {
        readCSV();
        User_1 user = usersTable.get(userName);
        if(user != null)
            return user.getTickets();
        return null;
    }

    /**
     * Retrieves list of all open tickets.
     * @return Linked list of all tickets that are unresolved.
     */
    public LinkedList<Ticket_1> getOpenTickets() {
        readCSV();
        Set<String> ticketSet = ticketsTable.keySet();
        LinkedList<Ticket_1> openTickets = new LinkedList();
        String[] temp = ticketSet.toString().substring(1, ticketSet.toString().length() - 1).split(",");
        for(String ID : temp) {

            Ticket_1 ticket = getTicket((ID.trim()));
            if(ticket != null && !ticket.isResolved())
                openTickets.add(ticket);
        }
        return openTickets;
    }

    /**
     * Allows a user to login to application
     * @param userName username for user to login.
     * @param password password for user to login.
     * @return user associated with username and password. null if otherwise.
     */
    public User_1 login(String userName, String password) {
        readCSV();
        User_1 user = usersTable.get(userName);
        if(user != null && password.equals(user.getPassword()))
            return user;                                    // correct login
        return null;                                        // incorrect login
    }

}
