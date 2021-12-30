/**
 * @author: Peter
 * @date: 29/12/2021
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        Technician t1 = new Technician("Jeff Smith", "Scanner");
        Technician t2 = new Technician("Jones Guan", "Ward");

        System.out.println(t1.getIdentity());
        System.out.println(t2.getIdentity());

    }
}

