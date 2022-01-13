

/**
 * @author: Peter
 * @date: 13/01/2022
 * @description:
 */
public class Main {
    public static void main(String[] args) {

        Teacher lizzy = new Teacher(1,"Lizzy",500);
        Teacher mellisa = new Teacher(2,"Mellisa",700);
        Teacher vanderhorn = new Teacher(3,"Vanderhorn",600);

        Student tamasha = new Student(1,"Tamasha",4);
        Student rakshith = new Student(2,"Rakshith Vasudev",12);
        Student rabbi = new Student(3,"Rabbi",5);

        School school = new School("No.1");
        school.addTeacher(lizzy);
        school.addTeacher(mellisa);
        school.addTeacher(vanderhorn);

        school.addStudent(tamasha);
        school.addStudent(rakshith);
        school.addStudent(rabbi);

        tamasha.payFees(5000);
        rakshith.payFees(6000);
        System.out.println("GHS has earned $"+ school.getTotalMoneyEarned());

        System.out.println("------Making SCHOOL PAY SALARY----");
        lizzy.receiveSalary(lizzy.getSalary());
        System.out.println("GHS has spent for salary to " + lizzy.getName()
                +" and now has $" + school.getTotalMoneyEarned());

        vanderhorn.receiveSalary(vanderhorn.getSalary());
        System.out.println("GHS has spent for salary to " + vanderhorn.getName()
                +" and now has $" + school.getTotalMoneyEarned());


        System.out.println(rakshith);

        mellisa.receiveSalary(mellisa.getSalary());

        System.out.println(mellisa);



    }
}
