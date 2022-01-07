import java.util.ArrayList;
import java.util.Random;

/**
 * @author: Peter
 * @date: 07/01/2022
 * @description:
 */
public class Member extends User {

    public Member() { }

    public void receive(ArrayList<Float> moneyList) {
        int idx = new Random().nextInt(moneyList.size());

        float delta = moneyList.remove(idx);

        super.setBalance(super.getBalance() + delta);
    }
}
