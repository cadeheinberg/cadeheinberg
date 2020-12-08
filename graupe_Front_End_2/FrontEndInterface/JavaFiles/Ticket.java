// --== CS400 File Header Information ==--
// Name: Elan Graupe
// Email: graupe@wisc.edu
// Team: BG
// Role: Front End Developer 2
// TA: Brianna Cochran
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

class Ticket{
    String customerName;
    String customerEmail;
    String title;
    String description;
    boolean resolved = false;

    public Ticket(String name, String email, String title, String description){
        this.customerName = name;
        this.customerEmail = email;
        this.title = title;
        this.description = description;
    }
}