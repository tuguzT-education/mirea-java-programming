package rtu.pract15_16.orders;

public class SortComparables {
    public static <T extends Comparable<? super T>> void sort(T[] comparables) {
        sort(comparables, 0, comparables.length - 1);
    }

    public static <T extends Comparable<? super T>> void sort(T[] comparables, final int begin, final int end) {
        if (begin < end) {
            int part = partition(comparables, begin, end);
            sort(comparables, begin, part);
            sort(comparables, part + 1, end);
        }
    }

    public static <T extends Comparable<? super T>> int partition(T[] comparables, final int begin, final int end) {
        final T pivot = comparables[(begin + end) / 2];
        int i = begin, j = end;
        while (true) {
            while (comparables[i].compareTo(pivot) > 0)
                ++i;
            while (comparables[j].compareTo(pivot) < 0)
                --j;

            if (i >= j)
                return j;
            T temp = comparables[i];
            comparables[i] = comparables[j];
            comparables[j] = temp;
            ++i;
            --j;
        }
    }
}