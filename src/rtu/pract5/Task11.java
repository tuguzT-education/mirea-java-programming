package rtu.pract5;

import java.util.Scanner;

public class Task11 {
    public static long get() {
        final Scanner scanner = new Scanner(System.in);
        final long number = scanner.nextLong();
        return recursion(Task10.getReversed(number), false);
    }

    private static long recursion(final long number, final boolean was0) {
        final long digit = number % 10;
        if (digit == 0) {
            if (was0) {
                return 0;
            }
            return recursion(number / 10, true);
        } else if (digit == 1) {
            return 1 + recursion(number / 10, false);
        }
        return recursion(number / 10, false);
    }
}
