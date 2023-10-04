package ex04;
import java.util.Scanner;

public class Program {
    public static final int SIZE = 65536, COUNT_MAX = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        scanner.close();

        int[] symbIter = countSymb(inputStr);
        int[] maxIter = findMax(symbIter);
        if (symbIter[maxIter[0]] > 999) {
            System.out.println("IllegalArgument");
        } else if (maxIter[0] > 0) {
            printChart(symbIter, maxIter);
        }
    }

    public static int[] countSymb(String inputStr) {
        int[] symbIter = new int[SIZE];
        char[] charStr = inputStr.toCharArray();
        for (int i = 0; i < inputStr.length(); i++) {
            symbIter[(int)charStr[i]]++;
        }
        return symbIter;
    }

    public static void insertElem(int[] maxIter, int[] symbIter, int symb) {
        int i = 0, elem = symbIter[symb];
        for (int iter : maxIter) {
            if (elem > symbIter[iter] || (elem == symbIter[iter] && symb < iter)) {
                break;
            }
            i++;
        }
        for (int j = COUNT_MAX - 1; j >= i + 1; j--) {
            maxIter[j] = maxIter[j - 1];
        }
        maxIter[i] = symb;
    }

    public static int[] findMax(int[] symbIter) {
        int[] maxIter = new int[COUNT_MAX];
        for (int i = 0; i < SIZE; i++) {
            if (symbIter[i] > 0 && symbIter[i] >= symbIter[maxIter[COUNT_MAX - 1]]) {
                insertElem(maxIter, symbIter, i);
            }
        }
        return maxIter;
    }

    public static void printChart(int[] symbIter, int[] maxIter) {
        int max = symbIter[maxIter[0]];
        int sizeTable = COUNT_MAX;
        for (int i = 0; i < COUNT_MAX; i++) {
            if (maxIter[i] == 0) {
                sizeTable = i;
            }
        }

        System.out.println();
        for (int i = 0; i < sizeTable; i++) {
            if (symbIter[maxIter[i]] == max) {
                System.out.printf("%d\t", symbIter[maxIter[i]]);
            }
        }
        System.out.println();
        for (int i = 10; i > 0; i--) {
            for (int j = 0; j < sizeTable; j++) {
                int countDelimiter = symbIter[maxIter[j]] * 10 / max;
                if (countDelimiter >= i) {
                    System.out.print("#\t");
                } else if (countDelimiter == i - 1) {
                    if (symbIter[maxIter[j]] != 0) {
                        System.out.printf("%d\t", symbIter[maxIter[j]]);
                    }
                }
            }
            System.out.println();
        }
        for (int i = 0; i < sizeTable; i++) {
            System.out.print((char)maxIter[i] + "\t");
        }
    }
}
