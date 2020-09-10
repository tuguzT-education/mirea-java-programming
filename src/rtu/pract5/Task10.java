package rtu.pract5;

public class Task10 {
    public static long getReversed(final long number) {
        return recursion(number, 0);
    }

    private static long recursion(final long number, final long l) {
        if (number == 0) {
            return l;
        }
        return recursion(number / 10, 10 * l + number % 10);
    }
}
