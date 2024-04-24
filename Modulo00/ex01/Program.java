/*
 * Classname
 * Program
 * Version information
 * Java 1.8
 * Date
 * 23/04/2024
 * Copyright notice
 */
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);
        int input;

        System.out.print("-> ");
        if (scanObj.hasNextInt()) {
            input = scanObj.nextInt();
            isPrime(input);
        } else {
            System.err.println("IllegalArgument");
            return;
        }
    }
    public static void isPrime(int num) {
        int power;
        int count = 0;

        if (num <= 1) {
            System.err.println("IllegalArgument");
            return ;
        }
        power = 2;
        while (power <= num / power) {
            if (num % power == 0) {
                System.out.println(("false " + count));
                return ;
            }
            power++;
            count++;
        }
        System.out.println(("true " + count));
    }
}