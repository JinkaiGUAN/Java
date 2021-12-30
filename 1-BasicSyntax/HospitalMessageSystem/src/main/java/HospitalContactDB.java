import java.util.ArrayList;

/**
 * @author: Peter
 * @date: 29/12/2021
 * @description:
 */
public class HospitalContactDB {
    ArrayList<Person> persons = new ArrayList<>();


    public void addDoctor(String name, String contactNum) {
        Doctor doctor = new Doctor(name);
        doctor.setPageNum(contactNum);
        persons.add(doctor);
    }

    public void addPatient(String name, String bedPhoneNum) {
        Patient patient = new Patient(name);
        patient.setBedPhoneNum(bedPhoneNum);
        persons.add(patient);
    }

    public void messageAll(String msg) {
        for (Person person: persons) {
            person.contact(msg);
        }

    }
}
