import java.util.Scanner;
import java.util.Random;

/**
 * @author: Peter
 * @date: 12/01/2022
 * @description:
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int passwordLength = 8;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    // constructor to receive the  first name and the last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created: " + this.firstName + " " + this.lastName);

        // call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Call a method that returns a random password.
        this.password = randomPassword(passwordLength);
        System.out.println("Password: " + this.password);

        // Combine  elements to generate email
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." +
                this.companySuffix;
        System.out.println("Email: " + this.email);
    }

    // ask for the department
    private String setDepartment() {
        System.out.print("Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter the department code: ");
        Scanner in = new Scanner(System.in);
        int departmentIdx = in.nextInt();
        if (departmentIdx == 1) {
            return "Sales";
        } else if (departmentIdx == 2) {
            return "Development";
        } else if (departmentIdx == 3) {
            return "Accounting";
        } else {
            return "";
        }
    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
        char[] password = new char[length];

        Random random = new Random();

        for (int i = 0; i < length; i++){
            password[i] = passwordSet.charAt(random.nextInt(passwordSet.length()));
        }

        return new String(password);
    }

    // Generate the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // Set alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Change the password
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
