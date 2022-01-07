import java.util.ArrayList;

/**
 * @author: Peter
 * @date: 07/01/2022
 * @description:
 */
public class Manager extends User{

    public Manager() {}

    public Manager(String name, float balance) {
        super(name, balance);
    }

    public ArrayList<Float> sendRedPacket(float totalMoney, int count) {
        ArrayList<Float> moneyList = new ArrayList<Float>();

        float leftBalance = super.getBalance();
        if (totalMoney > leftBalance) {
            System.out.println("Not enough balance!");
            return moneyList;
        }

        super.setBalance(leftBalance - totalMoney);

        float avg = totalMoney / count;
        float mod = totalMoney % count;

        for (int i = 0; i < count - 1; i++) {
            moneyList.add(avg);
        }
        moneyList.add(avg + mod);

        return moneyList;
    }
}
