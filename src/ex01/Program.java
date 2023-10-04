package ex01;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number <= 1) {
                System.err.println("IllegalArgument");
                scanner.close();
                System.exit(-1);
            } else {
                int it = 1;
                boolean result = true;
                for (int i = 2; i * i <= number; i++, it++) {
                    result = number % i != 0;
                    if (!result) { break; }
                }
                scanner.close();
                System.out.printf("%b %d\n", result, it);
            }
        }
    }
}
