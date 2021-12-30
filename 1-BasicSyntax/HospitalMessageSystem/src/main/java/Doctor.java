/**
 * @author: Peter
 * @date: 29/12/2021
 * @description:
 */
public class Doctor extends Person {

    public Doctor(String name) {
        super(name);
    }

    public String getPageNum() {
        return contactNum;
    }

    public void setPageNum(String pageNum) {
        contactNum = pageNum;
    }

    public void contact(String msg) {
        //todo: Add a patient as the input
        System.out.println("Paging Dr " + name + " on " + contactNum +  " Message: " + msg);
    }
}
