/**
 * @author: Peter
 * @date: 27/12/2021
 * @description:
 */
public class Game {
    private int score;

    public Game(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void displayInfo(){
        System.out.println("Hello, score is " + score);
    }

}
