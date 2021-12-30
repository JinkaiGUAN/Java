package DBEntities;

import DBEntities.Interfaces.Locatable;

/**
 * @author: Peter
 * @date: 29/12/2021
 * @description:
 */
public class Patient extends Person implements Locatable {

    public Patient(String name) {
        super(name);
    }

    public String getBedPhoneNum() {
        return contactNum;
    }

    public void setBedPhoneNum(String bedPhoneNum) {
        contactNum = bedPhoneNum;
    }

    @Override
    public void contact(String msg) {
        //todo: add a patient as the input.
        System.out.println("Paging patient " + name + " on " + contactNum +  " Message: " + msg);
    }

    @Override
    public String whereAmI() {
        return name + " is in the ward 5.";
    }
}
