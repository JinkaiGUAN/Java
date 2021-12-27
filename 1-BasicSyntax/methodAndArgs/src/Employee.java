/**
 * @author: Peter
 * @date: 27/12/2021
 * @description:
 */
public class Employee {
    String name;
    int year;
    int salary = 10000;

    public Employee(String name) {
        // constructor;
        this.name = name;
    }

    public Employee(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public int getSalary() {
        return salary;
    }

    public void quitJob() {
        System.out.println("I'm out!");
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Kevin");
        employee.quitJob();
        System.out.println(employee.name);
    }
}
