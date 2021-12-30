package DBEntities;

import DBEntities.Interfaces.Contactable;
import DBEntities.Interfaces.Locatable;

/**
 * @author: Peter
 * @date: 30/12/2021
 * @description:
 */
public class Technician extends Person implements Contactable, Locatable {
    public Technician(String name) {
        super(name);
    }

    @Override
    public void contact(String msg) {

    }

    @Override
    public String whereAmI() {
        return null;
    }
}
