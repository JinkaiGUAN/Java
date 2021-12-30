package DBEntities;

import DBEntities.Interfaces.Contactable;
import DBEntities.Interfaces.Locatable;

/**
 * @author: Peter
 * @date: 30/12/2021
 * @description:
 */
public class UltrasoundScanner extends Scanner implements Contactable, Locatable {
    public UltrasoundScanner(String IDnum) {
        super(IDnum);
    }

    @Override
    public void contact(String msg) {
        System.out.println("Contacted DBEntities.UltrasoundScanner ID: " + IDnum + " Message: " + msg);
     }


    @Override
    public String whereAmI() {
        return "US DBEntities.Scanner " + IDnum + " is in ward 5. " ;
    }
}
