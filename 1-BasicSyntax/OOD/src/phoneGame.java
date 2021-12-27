/**
 * @author: Peter
 * @date: 27/12/2021
 * @description:
 */
public class phoneGame extends Game {
//    private int score;

    public phoneGame(int score) {
        super(score);
    }

    public void displayInfo() {
        System.out.println("phoneGame with score of " + getScore());
    }

    public static void main(String[] args) {
        phoneGame pg = new phoneGame(18);
        pg.displayInfo();
    }

}
