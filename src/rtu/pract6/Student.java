package rtu.pract6;

import java.util.Arrays;
import java.util.Comparator;

public class Student {
    private final byte[] finalMarks;
    private final String name;

    public Student(final String name, final byte[] finalMarks) {
        this.finalMarks = finalMarks.clone();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public byte[] getFinalMarks() {
        return finalMarks;
    }

    @Override
    public String toString() {
        return "Student{finalMarks = " + Arrays.toString(finalMarks)
                + ", name = '" + name + "'}";
    }

    private static double getAverageMark(final Student student) {
        double mark = 0;
        for (final var item : student.finalMarks) {
            mark += item;
        }
        return mark / student.finalMarks.length;
    }

    public static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student lhs, Student rhs) {
            return Double.compare(getAverageMark(lhs), getAverageMark(rhs));
        }
    }
}
