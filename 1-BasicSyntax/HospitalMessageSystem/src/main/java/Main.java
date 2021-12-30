import javax.print.Doc;

/**
 * @author: Peter
 * @date: 29/12/2021
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        HospitalContactDB db = new HospitalContactDB();
        db.addDoctor("Martin Holloway", "78668898");
        db.addDoctor("Jeff Lynne", "9998");
        db.addDoctor("Harold Green", "554698");

        db.messageAll("Emergency - clear the hospital!");

    }
}
