/**
 * @author: Peter
 * @date: 07/01/2022
 * @description:
 */
public class User {

    private String name;
    private float balance;

    public User() { }

    public User(String name, float balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    // show the balance of current user
    public void displayInfo() {
        System.out.println(name + " has a balance of " + balance);
    }


}
