/**
 * @author: Peter
 * @date: 13/01/2022
 * @description:
 */
public class Student extends People {

    private int grade;
    private int feesPaid;
    private int feesTotal;

    // This constructor has some problems, since we might some information here
    public Student() {}

    public Student(int id, String name, int grade) {
        super(id, name);
        this.grade = grade;
        this.feesPaid = 0;
        this.feesTotal = 30000;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getFeesTotal() {
        return feesTotal;
    }

    public void setFeesTotal(int feesTotal) {
        this.feesTotal = feesTotal;
    }

    public void payFees(int fees) {
        feesPaid += fees;
        // todo: add school manager here
        School.updateTotalMoneyEarned(feesPaid);
    }

    public int getRemainingFees() {
        return feesTotal - feesPaid;
    }

    @Override
    public String toString() {
        return "Student name: " + super.getName() + ". Total fees paid so far $" + feesPaid;
    }



}
