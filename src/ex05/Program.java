package ex05;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nameList = inputNames(scanner);
        boolean[][] classesList = inputClasses(scanner);
        int[][][] attendanceList = inputAttendance(scanner, nameList);
        scanner.close();

        printTable(nameList, classesList, attendanceList);
    }


    public static String[] inputNames(Scanner scanner) {
        String[] nameList = new String[10];
        int i = 0;
        String str = scanner.nextLine();
        while (!str.equals(".")) {
            nameList[i++] = str;
            str = scanner.nextLine();
        }
        return nameList;
    }

    public static boolean[][] inputClasses(Scanner scanner) {
        int time, day = 0;
        boolean[][] classesList = new boolean[7][5];
        char[] line;
        String str = scanner.nextLine();
        while (!str.equals(".")) {
            line = str.toCharArray();
            if (line[2] == 'M' && line[3] == 'O') {
                day = 0;
            } else if (line[2] == 'T' && line[3] == 'U') {
                day = 1;
            } else if (line[2] == 'W' && line[3] == 'E') {
                day = 2;
            } else if (line[2] == 'T' && line[3] == 'H') {
                day = 3;
            } else if (line[2] == 'F' && line[3] == 'R') {
                day = 4;
            } else if (line[2] == 'S' && line[3] == 'A') {
                day = 5;
            } else if (line[2] == 'S' && line[3] == 'U') {
                day = 6;
            } else {
                day = 7;
            }
            if (day != 7) {
                time = line[0] - 49;
                classesList[day][time] = true;
            }
            str = scanner.nextLine();
        }
        return classesList;
    }

    public static int[][][] inputAttendance(Scanner scanner, String[] nameList) {
        int[][][] attendanceList = new int[10][30][5];
        int nameNumber, time, day, status;
        String str = scanner.next();
        while (!str.equals(".")) {
            nameNumber = getNameNumber(nameList, str);
            time = scanner.nextInt() - 1;
            day = scanner.nextInt() - 1;
            str = scanner.next();
            status = 0;
            if (str.equals("NOT_HERE")) {
                status = -1;
            } else if (str.equals("HERE")) {
                status = 1;
            }
            attendanceList[nameNumber][day][time] = status;
            str = scanner.next();
        }
        return attendanceList;
    }

    public static int getNameNumber(String[] nameList, String name) {
        int i = 0;
        for (; i < 10 && nameList[i] != null && !nameList[i].equals(name); i++) {
        }
        return i;
    }

    public static void printTable(String[] nameList, boolean[][] classesList, int[][][] attendanceList) {
        int day_week;

        System.out.printf("%10s", "");
        for (int d = 1; d <= 30; d++) {
            day_week = d % 7;
            for (int t = 0; t < 5; t++) {
                if (classesList[day_week][t]) {
                    System.out.printf("%1d:00%3s%3d|", t + 1, getDayWeek(day_week), d);
                }
            }
        }
        System.out.println();

        for (int i = 0; i < 10 && nameList[i] != null; i++) {
            System.out.printf("%10s", nameList[i]);
            for (int d = 1; d <= 30; d++) {
                day_week = d % 7;
                for (int t = 0; t < 5; t++) {
                    if (classesList[day_week][t] && attendanceList[i][d - 1][t] == 0) {
                        System.out.printf("%10s|", "");
                    } else if (classesList[day_week][t]) {
                        System.out.printf("%10d|", attendanceList[i][d - 1][t]);
                    }
                }
            }
            System.out.println();
        }
    }

    public static String getDayWeek(int i) {
        String day = "";
        switch (i) {
            case 0:
                day = "MO";
                break;
            case 1:
                day = "MO";
                break;
            case 2:
                day = "WE";
                break;
            case 3:
                day = "Hh";
                break;
            case 4:
                day = "FR";
                break;
            case 5:
                day = "SA";
                break;
            case 6:
                day = "SU";
                break;
        }
        return day;
    }

}

