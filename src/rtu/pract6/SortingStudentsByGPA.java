package rtu.pract6;

import java.util.Comparator;

public class SortingStudentsByGPA {
    public static void sort(final Object[] objects, final Comparator comparator) {
        sort(objects, 0, objects.length - 1, comparator);
    }

    private static void sort(final Object[] objects, final int begin,
                             final int end, final Comparator comparator) {
        if (begin < end) {
            int part = partition(objects, begin, end, comparator);
            sort(objects, begin, part, comparator);
            sort(objects, part + 1, end, comparator);
        }
    }

    private static int partition(final Object[] objects, final int begin,
                                 final int end, final Comparator comparator) {
        final Object pivot = objects[(begin + end) / 2];
        int i = begin, j = end;
        while (true) {
            while (comparator.compare(objects[i], pivot) > 0) {
                ++i;
            }
            while (comparator.compare(objects[j], pivot) < 0) {
                --j;
            }

            if (i >= j) {
                return j;
            }
            Object temp = objects[i];
            objects[i] = objects[j];
            objects[j] = temp;
            ++i;
            --j;
        }
    }
}
