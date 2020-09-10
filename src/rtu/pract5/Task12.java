package rtu.pract5;

import java.util.Scanner;

public class Task12 {
    public static void get() {
        final Scanner scanner = new Scanner(System.in);
        final long number = scanner.nextLong();
        recursion(Task10.getReversed(number));
        System.out.println();
    }

    private static void recursion(final long number) {
        final long digit = number % 10;
        if (digit == 0) {
            return;
        }
        if (digit % 2 != 0) {
            System.out.print(digit);
        }
        recursion(number / 10);
    }
}
