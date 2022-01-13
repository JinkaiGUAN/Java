/**
 * @author: Peter
 * @date: 12/01/2022
 * @description:
 */
public class Teacher extends People{
//    private int id;
//    private int name;
    private int salary;
    private int salaryEarned;

    public Teacher() {}

    public Teacher(int id, String name, int salary) {
        super(id, name);
        this.salary = salary;
        this.salaryEarned = 0;
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void receiveSalary(int salary) {
        salaryEarned += salary;
        School.updateTotalMoneySpent(salary);

    }

    @Override
    public String toString() {
        return "Name of the Teacher: " + getName() + ". Total salary earned so far $" + salaryEarned;
    }


}
