/**
 * @author: Peter
 * @date: 29/12/2021
 * @description:
 */
public abstract class Person {
    protected String name;
    protected String contactNum;

    public Person(String name) {
        this.name = name;
    }

    public abstract void contact(String msg);


}
