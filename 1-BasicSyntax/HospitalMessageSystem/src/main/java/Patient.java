/**
 * @author: Peter
 * @date: 29/12/2021
 * @description:
 */
public class Patient extends Person{

    public Patient(String name) {
        super(name);
    }

    public String getBedPhoneNum() {
        return contactNum;
    }

    public void setBedPhoneNum(String bedPhoneNum) {
        contactNum = bedPhoneNum;
    }

    public void contact(String msg) {
        //todo: add a patient as the input.
        System.out.println("Paging patient " + name + " on " + contactNum +  " Message: " + msg);
    }

}
