package ex03;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        long tests = 0;
        Scanner scanner = new Scanner(System.in);
        boolean numberIsOk;
        String inputStr = scanner.next();
        int weekNumber = 0, lastNumber = 0;
        while (!inputStr.equals("42")) {
            numberIsOk = scanner.hasNextInt();
            weekNumber = numberIsOk ? scanner.nextInt() : 0;
            if (numberIsOk && (weekNumber - lastNumber == 1)) {
                tests += findMinTest(scanner, weekNumber);
            } else {
                System.err.println("IllegalArgument");
                scanner.close();
                System.exit(-1);
            }
            lastNumber = weekNumber;
            inputStr = scanner.next();
        }
        scanner.close();
        printTests(tests);
    }
    public static long findMinTest(Scanner scanner, int weekNumber) {
        long min = 0, test;
        for (int i = 0; i < 5; ++i) {
            test = scanner.hasNextInt() ? scanner.nextInt() : 0;
            if (test < 1 || test > 9) {
                System.err.println("IllegalArgument");
                scanner.close();
                System.exit(-1);
            }
            if (i == 0) {
                min = test;
            } else if (test < min) {
                min = test;
            }
        }
        for (int i = 1; i < weekNumber; i++) {
            min *= 10;
        }
        return min;
    }
    public static void printTests(long number) {
        long test, i = 1;
        while (number != 0) {
            test = number % 10;
            number /= 10;
            System.out.printf("Week %d ", i);
            for (int j = 0; j < test; ++j) {
                System.out.print("=");
            }
            System.out.println(">");
            ++i;
        }
    }
}
