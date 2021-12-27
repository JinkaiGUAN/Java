package stanford;

/**
 * @author: Peter
 * @date: 27/12/2021
 * @description:
 */
import harvard.Student;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("BMW", 1000);
        System.out.println(map.get("BMW"));

        Student hStudent = new Student();
        hStudent.greet();
    }
}
