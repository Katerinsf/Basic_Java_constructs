package ex02;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number, sum, count = 0;
        boolean result;

        while ((number = scanner.nextInt()) != 42) {
            sum = getSum(number);
            result = isPrime(sum);

            if (result) { ++count; }
        }

        scanner.close();
        System.out.printf("Count of coffee-request – %d\n", count);
    }

    public static int getSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static boolean isPrime(int number) {
        boolean result = number == 1 ? false : true;
        for (int i = 2; i * i <= number && result; i++) {
            result = number % i != 0;
        }
        return result;
    }
}
