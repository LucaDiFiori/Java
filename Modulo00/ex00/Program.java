/*
 * Classname
 * Program
 * Version information
 * Java 1.8
 * Date
 * 23/04/2024
 * Copyright notice
 */
public class Program {
    public static void main(String[] args) {
        int num = 479598;
        int sum = sumDigits(num);
        System.out.println(sum);
    }
    public static int sumDigits (int num) {
        int sum = 0;

        sum += num % 10;
        num /= 10;
        sum += num % 10;
        num /= 10;
        sum += num % 10;
        num /= 10;
        sum += num % 10;
        num /= 10;
        sum += num % 10;
        num /= 10;
        sum += num % 10;
        num /= 10;
        return (sum);
    }
}

