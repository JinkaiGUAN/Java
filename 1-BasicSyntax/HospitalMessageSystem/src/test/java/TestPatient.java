import DBEntities.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author: Peter
 * @date: 30/12/2021
 * @description:
 */
public class TestPatient {
    Patient pat;
    String name = "Martin";

    @BeforeEach
    public void setUP() {
        pat = new Patient(name);
    }

    @Test // why do we import Test from org.junit.jupiter.api.Test
    public void testWhereAmI() {
        String loc = pat.whereAmI();
        Assertions.assertEquals("Martin is in the ward 5.", loc);
    }

    @Test
    public void testContact() {
        String bedPhoneNum = "12455ada";
        String msg = "Hello world!";

        pat.setBedPhoneNum(bedPhoneNum);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tempStore;

        // Store current output stream
        tempStore = System.out;
        // Capture and replace System.out with my own output stream
        System.setOut(new PrintStream(baos));
        pat.contact(msg);
        // Restore system.out
        System.setOut(tempStore);

        Assertions.assertEquals("Paging patient " + name + " on " + bedPhoneNum +  " Message: " + msg,
                baos.toString().trim());
    }
}
