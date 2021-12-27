/**
 * @author: Peter
 * @date: 27/12/2021
 * @description:
 */
public class videoGame extends Game {
//    private int score;

    public videoGame(int score) {
        super(score);
    }

    public void displayInfo() {
        System.out.println("VideoGame with score of " + getScore());
    }

    public static void main(String[] args) {
        videoGame vg = new videoGame(19);
        vg.displayInfo();
    }
}
