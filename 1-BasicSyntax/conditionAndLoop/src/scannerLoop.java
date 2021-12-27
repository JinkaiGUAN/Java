/**
 * @author: Peter
 * @date: 27/12/2021
 * @description:
 */
import java.util.Scanner;


public class scannerLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please enter the first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Please enter the second number: ");
            int num2 = scanner.nextInt();

            if (num1 > num2) {
                break;
            }


            for (int num = num1; num <= num2;  num ++) {
                if (num % 2 == 1){
                    System.out.print(num);
                }
            }

        }
    }
}
