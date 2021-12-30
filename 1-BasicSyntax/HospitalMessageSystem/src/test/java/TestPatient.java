import DBEntities.Patient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * @author: Peter
 * @date: 30/12/2021
 * @description:
 */
public class TestPatient {

    @Test // why do we import Test from org.junit.jupiter.api.Test
    public void testWhereAmI() {
        Patient pat = new Patient("Martin");
        String loc = pat.whereAmI();
        Assertions.assertEquals("Martin is in the ward 5.", loc);
    }
}
