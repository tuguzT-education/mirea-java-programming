package rtu.pract6;

import java.util.Comparator;

public class SortingStudentsByGPA {
    public static void sort(final Student[] students, final Comparator comparator) {
        sort(students, 0, students.length - 1, comparator);
    }

    private static void sort(final Student[] students, final int begin,
                             final int end, final Comparator comparator) {
        if (begin < end) {
            int part = partition(students, begin, end, comparator);
            sort(students, begin, part, comparator);
            sort(students, part + 1, end, comparator);
        }
    }

    private static int partition(final Student[] students, final int begin,
                                 final int end, final Comparator comparator) {
        final Student pivot = students[(begin + end) / 2];
        int i = begin, j = end;
        while (true) {
            while (comparator.compare(students[i], pivot) < 0) {
                ++i;
            }
            while (comparator.compare(students[j], pivot) > 0) {
                --j;
            }

            if (i >= j) {
                return j;
            }
            Student temp = students[i];
            students[i] = students[j];
            students[j] = temp;
            ++i;
            --j;
        }
    }
}
