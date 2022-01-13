import java.util.Scanner;
/**
 * @author: Peter
 * @date: 13/01/2022
 * @description:
 */
public class Student {
    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = null;
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000; // static means that the property is bound to the class.

    // constructor
    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();

        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();

        System.out.print("-------Checking Student Level-------\n1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior\nEnter student class level: ");
        this.gradeYear = in.nextInt();

        this.id++;
        setStudentID();

        System.out.println("First name: " + firstName + ". Last name: " + lastName + ". Grade year: " +
                gradeYearIdx2String(gradeYear) + ". Student ID: " + studentID);

    }

    public String gradeYearIdx2String(int idx) {
        if (idx == 1) {
            return "Freshmen";
        } else if (idx == 2) {
            return "Sophmore";
        } else if (idx == 3) {
            return "Junior";
        } else if (idx == 4) {
            return "Senior";
        } else {
            return "";
        }
    }

    // Create ID
    private void setStudentID() {
        // grade level + id
        this.studentID =  gradeYear + "" + id;
    }

    // enroll in course
    public void enroll() {

        do{
            System.out.print("Enter the course to enrol (q to quit): ");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("q")) {
                courses = courses + "\n" + course;
                tuitionBalance += costOfCourse;
            } else {
                break;
            }
        } while (1 != 0);

        System.out.println("Enrolled in: " + courses);
        System.out.println("Tuition balance: " + tuitionBalance);
    }

    public void viewBalance() {
        System.out.println("Your balance is: $" + tuitionBalance);
    }

    public void payTuition(int payment) {
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }




}
