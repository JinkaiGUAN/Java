import DBEntities.*;
import DBEntities.Interfaces.Contactable;
import DBEntities.Interfaces.Locatable;

import java.util.ArrayList;

/**
 * @author: Peter
 * @date: 29/12/2021
 * @description:
 */
public class HospitalContactDB {
    ArrayList<Contactable> contacts = new ArrayList<>();
    ArrayList<Locatable> locList = new ArrayList<>();

    public void addDoctor(String name, String contactNum) {
        Doctor doctor = new Doctor(name);
        doctor.setPageNum(contactNum);
        contacts.add(doctor);
    }

    public void addPatient(String name, String bedPhoneNum) {
        Patient patient = new Patient(name);
        patient.setBedPhoneNum(bedPhoneNum);
        contacts.add(patient);
        locList.add(patient);
    }

    public void addUltrasoundScanner(String IDnum) {
        UltrasoundScanner scanner = new UltrasoundScanner(IDnum);
        contacts.add(scanner);
        locList.add(scanner);
    }

    public void messageAll(String msg) {
        for (Contactable contactor: contacts) {
            contactor.contact(msg);
        }
    }

    public String locateAll() {
        String ret = new String();
        for (Locatable locator: locList) {
            ret += locator.whereAmI() + "\n";
        }

        return ret;
    }
}
