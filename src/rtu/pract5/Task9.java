package rtu.pract5;

public class Task9 {
    public static long get(final long a, final long b) {
        if (a > b + 1) {
            return 0;
        }
        if (a == 0 || b == 0) {
            return 1;
        }
        return get(a, b - 1) + get(a - 1, b - 1);
    }
}
